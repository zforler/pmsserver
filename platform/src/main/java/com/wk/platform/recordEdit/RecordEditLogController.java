package com.wk.platform.recordEdit;

import com.wk.bean.RecordEditLog;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordEditLogController {
    private final Logger logger = LoggerFactory.getLogger(RecordEditLogController.class);
    @Autowired
    private RecordEditLogService recordEditLogService;

    @ApiOperation("添加修改记录")
    @PostMapping("/recordEditLog")
    public Result<RecordEditLog> addRecordEditLog(RecordEditLog recordEditLog, String operateUserId){
        try {
            Result<RecordEditLog> result = recordEditLogService.addRecordEditLog(recordEditLog, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业修改记录列表")
    @GetMapping("/getRecordEditLogList")
    public Result<List<RecordEditLog>> getRecordEditLogList(String keyword,String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return recordEditLogService.getRecordEditLogList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取修改记录分页列表")
    @GetMapping("/getRecordEditLogPageList")
    public Result<PageList<RecordEditLog>> getRecordEditLogPageList(String keyword,String customerId, int page,
                                                                    int size, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return recordEditLogService.getRecordEditLogPageList(keyword,customerId, page, size, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
