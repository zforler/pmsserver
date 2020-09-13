package com.wk.platform.report;

import com.wk.bean.Report;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import com.wk.platform.report.ReportController;
import com.wk.platform.report.ReportService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {
    private final Logger logger = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    private ReportService reportService;

    @ApiOperation("添加报表")
    @PostMapping("/report")
    public Result<Report> addReport(Report report, String operateUserId){
        try {
            Result<Report> result = reportService.addReport(report, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改报表")
    @PostMapping("/updateReport")
    public Result<Report> updateReport(Report report, String operateUserId){
        try {
            Result<Report> result = reportService.updateReport(report, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除报表")
    @PostMapping("/deleteReport")
    public Result<Report> deleteReport(@RequestParam(defaultValue = "-1",required = true) int reportId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Report> result = reportService.deleteReport(reportId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取报表列表")
    @GetMapping("/getReportList")
    public Result<List<Report>> getReportList(String keyword, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return reportService.getReportList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation("获取企业下报表列表")
    @GetMapping("/getAuthReportList")
    public Result<List<Report>> getAuthReportList(String keyword,String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return reportService.getAuthReportList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("分配报表")
    @PostMapping("/shareReport")
    public Result shareReport(String customerIds, int reportId, String operateUserId){
        try {
            return reportService.shareReport(customerIds,reportId, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("取消分配报表")
    @PostMapping("/cancleShareReport")
    public Result cancleShareReport(String customerIds, int reportId, String operateUserId){
        try {
            return reportService.cancleShareReport(customerIds,reportId, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
