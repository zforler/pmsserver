package com.wk.platform.salaryAdjust;

import com.wk.bean.SalaryAdjustLog;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalaryAdjustLogServiceImpl implements SalaryAdjustLogService {
    @Autowired
    private SalaryAdjustLogRepo salaryAdjustLogRepo;
    @Autowired
    private CommonService commonService;

    @Override
    public Result<SalaryAdjustLog> addSalaryAdjustLog(SalaryAdjustLog salaryAdjustLog, String operateUserId) {
        salaryAdjustLog.setUpdateTime(TimeUtil.getCurrentInSecond());
        salaryAdjustLog.setOperateUserId(operateUserId);
        SalaryAdjustLog salaryAdjustLog1 = salaryAdjustLogRepo.saveAndFlush(salaryAdjustLog);
        return Result.success(salaryAdjustLog1);
    }

    @Override
    public Result<List<SalaryAdjustLog>> getSalaryAdjustLogList(String customerId, String staffNo, int year, int month,
                                                                int day, String operateUserId) {
        String sql = "SELECT sal.*,ui.user_name from salary_adjust_log sal LEFT JOIN user_info ui ON" +
                " sal.operate_user_id=ui.user_id WHERE sal.customer_id=:customerId AND sal.staff_no=:staffNo" +
                " AND sal.`year`=:year AND sal.`month`=:month AND sal.`day`=:day";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        param.put("staffNo",staffNo);
        param.put("year",year);
        param.put("month",month);
        param.put("day",day);

        List<SalaryAdjustLog> salaryAdjustLogs = commonService.listBySql(sql, param, SalaryAdjustLog.class);

        return Result.success(salaryAdjustLogs);
    }
}
