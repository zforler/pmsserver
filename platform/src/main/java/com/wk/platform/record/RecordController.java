package com.wk.platform.record;

import com.wk.bean.Price;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RecordController {
    private final Logger logger = LoggerFactory.getLogger(RecordController.class);
    @Autowired
    private RecordService recordService;

    @ApiOperation("获取生产记录")
    @GetMapping("/getRecordList")
    public Result<List<Map<String,Object>>> getRecordList(String customerId,
                                                          @RequestParam(required = false,defaultValue = "-1") int beginTime,
                                                          @RequestParam(required = false,defaultValue = "-1") int endTime, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return recordService.getRecordList(customerId,beginTime,endTime,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("日工资")
    @GetMapping("/getSalaryReportList")
    public Result<List<Map<String,Object>>> getSalaryReportList(String customerId,
                                                          @RequestParam(required = false,defaultValue = "-1") int beginTime,
                                                          @RequestParam(required = false,defaultValue = "-1") int endTime, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return recordService.getSalaryReportList(customerId,beginTime,endTime,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("月工资工资")
    @GetMapping("/getMonthSalaryReportList")
    public Result<List<Map<String,Object>>> getMonthSalaryReportList(String customerId,
                                                                     @RequestParam(required = false,defaultValue = "-1") int beginTime,
                                                                     @RequestParam(required = false,defaultValue = "-1") int endTime, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return recordService.getMonthSalaryReportList(customerId,beginTime,endTime,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("产量统计")
    @GetMapping("/getProductionReportdList")
    public Result<List<Map<String,Object>>> getProductionReportdList(String customerId,
                                                                     @RequestParam(required = false,defaultValue = "-1") int beginTime,
                                                                     @RequestParam(required = false,defaultValue = "-1") int endTime, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return recordService.getProductionReportdList(customerId,beginTime,endTime,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("出成率统计")
    @GetMapping("/getYieldReportList")
    public Result<List<Map<String,Object>>> getYieldReportList(String customerId,
                                                                     @RequestParam(required = false,defaultValue = "-1") int beginTime,
                                                                     @RequestParam(required = false,defaultValue = "-1") int endTime, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return recordService.getYieldReportList(customerId,beginTime,endTime,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
