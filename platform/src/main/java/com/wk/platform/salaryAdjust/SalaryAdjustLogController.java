package com.wk.platform.salaryAdjust;

import com.wk.bean.SalaryAdjustLog;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalaryAdjustLogController {
    private final Logger logger = LoggerFactory.getLogger(SalaryAdjustLogController.class);
    @Autowired
    private SalaryAdjustLogService salaryAdjustLogService;
    
    @ApiOperation("添加工资调整")
    @PostMapping("/addSalaryAdjustLog")
    public Result<SalaryAdjustLog> addSalaryAdjustLog(SalaryAdjustLog salaryAdjustLog, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return salaryAdjustLogService.addSalaryAdjustLog(salaryAdjustLog, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("获取工资调整列表")
    @GetMapping("/getSalaryAdjustLogList")
    public Result<List<SalaryAdjustLog>> getSalaryAdjustLogList(String customerId,String staffNo,int year,int month,int day
            , String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return salaryAdjustLogService.getSalaryAdjustLogList(customerId,staffNo, year, month, day,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
