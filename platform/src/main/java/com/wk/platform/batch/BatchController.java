package com.wk.platform.batch;

import com.wk.bean.Batch;
import com.wk.bean.BatchItem;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.platform.batch.BatchController;
import com.wk.platform.batch.BatchService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BatchController {
    private final Logger logger = LoggerFactory.getLogger(BatchController.class);
    @Autowired
    private BatchService batchService;

    @ApiOperation("添加批次")
    @PostMapping("/batch")
    public Result<Batch> addBatch(Batch batch, String operateUserId){
        try {
            Result<Batch> result = batchService.addBatch(batch, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改产品")
    @PostMapping("/updateBatch")
    public Result<Batch> updateBatch(Batch batch, String operateUserId){
        try {
            Result<Batch> result = batchService.updateBatch(batch, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除产品")
    @PostMapping("/deleteBatch")
    public Result<Batch> deleteBatch(String batchId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Batch> result = batchService.deleteBatch(batchId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下产品列表")
    @GetMapping("/getBatchList")
    public Result<List<Batch>> getBatchList(String keyword, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return batchService.getBatchList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation("添加自定义批次")
    @PostMapping("/batchItem")
    public Result<BatchItem> addBatchItem(BatchItem batchItem, String operateUserId){
        try {
            Result<BatchItem> result = batchService.addBatchItem(batchItem, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改自定义批次")
    @PostMapping("/updateBatchItem")
    public Result<BatchItem> updateBatchItem(BatchItem batchItem, String operateUserId){
        try {
            Result<BatchItem> result = batchService.updateBatchItem(batchItem, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除自定义批次")
    @PostMapping("/deleteBatchItem")
    public Result<BatchItem> deleteBatchItem(String id, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<BatchItem> result = batchService.deleteBatchItem(id, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation("获取自定义批次分页列表")
    @GetMapping("/getBatchItemPageList")
    public Result<PageList<BatchItem>> getBatchItemPageList(String keyword, int page, int size, String batchId,String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return batchService.getBatchItemPageList(keyword, batchId, page, size, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
