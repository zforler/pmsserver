package com.wk.platform.report;

import com.wk.bean.Report;
import com.wk.bean.ReportAuth;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;
    @Autowired
    private ReportRepo reportRepo;
    @Autowired
    private ReportAuthRepo reportAuthRepo;

    @Transactional
    @Override
    public Result<Report> addReport(Report report, String operateUserId) {
        Report p = reportRepo.findFirstByReportName(report.getReportName());
        if(p != null){
            return Result.error("产报表名称重复");
        }
        int currentInSecond = TimeUtil.getCurrentInSecond();
        report.setCreateTime(currentInSecond);
        report.setUpdateTime(currentInSecond);
        report.setStatus(0);

        Report newReport = reportRepo.saveAndFlush(report);

        return Result.success(newReport);
    }

    @Transactional
    @Override
    public Result updateReport(Report report, String operateUserId) {
        int reportId = report.getReportId();
        Report old = reportRepo.findFirstByReportId(reportId);
        if(old == null){
            return Result.error("没有此报表");
        }
        Report checkOld = reportRepo.findFirstByReportNameAndReportIdNot(report.getReportName(),reportId);
        if(checkOld != null){
            return Result.error("产报表名称重复");
        }
        int currentInSecond = TimeUtil.getCurrentInSecond();
        report.setCreateTime(old.getCreateTime());
        report.setUpdateTime(currentInSecond);
        report.setStatus(old.getStatus());

        reportRepo.saveAndFlush(report);

        return Result.success();
    }

    @Transactional
    @Override
    public Result deleteReport(int reportId, String operateUserId) {
        reportRepo.deleteAllByReportId(reportId);
        reportAuthRepo.deleteAllByReportId(reportId);
        return Result.success();
    }

    @Override
    public Result<List<Report>> getReportList(String keyword, String customerId, String operateUserId) {
        if(!"0000".equals(customerId)){
            return getAuthReportList(keyword,customerId,operateUserId);
        }
        String sql = "SELECT * FROM report WHERE 1=1 ";
        Map<String,Object> param = new HashMap<>();

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (report_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Report> reports = commonService.listBySql(sql, param, Report.class);

        return Result.success(reports);
    }

    @Override
    public Result<List<Report>> getAuthReportList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT * FROM report WHERE report_id in (SELECT report_id FROM report_auth WHERE customer_id=:customerId) ";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (report_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Report> reports = commonService.listBySql(sql, param, Report.class);

        return Result.success(reports);
    }
    @Transactional
    @Override
    public Result shareReport(String customerIds, int reportId, String operateUserId) {
        if(StringUtils.isBlank(customerIds)){
            return Result.error("请选择客户");
        }
        String[] ids = customerIds.split(",");
        List<ReportAuth> reportAuths = new ArrayList<>();
        int second = TimeUtil.getCurrentInSecond();
        for (int i = 0, len = ids.length; i < len; i++) {
            ReportAuth reportAuth = new ReportAuth();
            reportAuth.setCustomerId(ids[i]);
            reportAuth.setReportId(reportId);
            reportAuth.setUpdateTime(second);
            reportAuths.add(reportAuth);
        }
        reportAuthRepo.saveAll(reportAuths);
        return Result.success();
    }
    @Transactional
    @Override
    public Result cancleShareReport(String customerIds, int reportId, String operateUserId) {
        if(StringUtils.isBlank(customerIds)){
            return Result.error("请选择客户");
        }
        String[] ids = customerIds.split(",");
        for (int i = 0, len = ids.length; i < len; i++) {
           reportAuthRepo.deleteByCustomerIdAndReportId(ids[i],reportId);
        }
        return Result.success();
    }
}
