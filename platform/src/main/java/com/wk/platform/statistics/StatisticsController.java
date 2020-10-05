package com.wk.platform.statistics;

import com.wk.bean.SysLog;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.platform.sysLog.SysLogController;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatisticsController {
    private final Logger logger = LoggerFactory.getLogger(StatisticsController.class);
    @Autowired
    private StatisticsService statisticsService;
    
    @ApiOperation("获取操员工数量")
    @GetMapping("/getStaffCount")
    public Result<Integer> getStaffCount(String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return statisticsService.getStaffCount(customerId,operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("获取产品数量")
    @GetMapping("/getProductionCount")
    public Result<Integer> getProductionCount( String customerId,String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return statisticsService.getProductionCount(customerId, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("获取设备数量")
    @GetMapping("/getEquipmentCount")
    public Result<Integer> getEquipmentCount(String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return statisticsService.getEquipmentCount(customerId, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("获取生产总量")
    @GetMapping("/getProductionSummary")
    public Result<Map<String, Object>> getProductionSummary(String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return statisticsService.getProductionSummary(customerId, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("每日产量变化趋势")
    @GetMapping("/getProductionSummaryEveryDay")
    public Result<Map<String, Object>> getProductionSummaryEveryDay(String customerId,
                                                                @RequestParam(defaultValue = "-1",required = false) int beginTime,
                                                                @RequestParam(defaultValue = "-1",required = false) int endTime,
                                                                String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return statisticsService.getProductionSummaryEveryDay(customerId,beginTime,endTime, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("每日产量统计")
    @GetMapping("/getProductionSummaryMonth")
    public Result<Map<String, Object>> getProductionSummaryMonth(String customerId,
                                                                    @RequestParam(defaultValue = "-1",required = false) int beginTime,
                                                                    @RequestParam(defaultValue = "-1",required = false) int endTime,
                                                                    String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return statisticsService.getProductionSummaryMonth(customerId,beginTime,endTime, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
