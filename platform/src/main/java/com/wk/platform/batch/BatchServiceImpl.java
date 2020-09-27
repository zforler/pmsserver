package com.wk.platform.batch;

import com.wk.bean.Batch;
import com.wk.bean.BatchItem;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    private BatchRepo batchRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;
    @Autowired
    private BatchItemRepo batchItemRepo;

    @Transactional
    @Override
    public Result<Batch> addBatch(Batch batch, String operateUserId) {
        Batch b = batchRepo.findFirstByBatchNameAndCustomerId(batch.getBatchName(), batch.getCustomerId());
        if(b != null){
            return Result.error("批次名称已存在");
        }
        String batchId = seqService.getNextBusinessId(Const.BZ_BATCH, batch.getCustomerId(), 2);
        batch.setBatchId(batchId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        batch.setCreateTime(currentInSecond);
        batch.setUpdateTime(currentInSecond);
        Batch newBatch = batchRepo.saveAndFlush(batch);
        return Result.success(newBatch);
    }

    @Override
    public Result updateBatch(Batch batch, String operateUserId) {
        Batch b = batchRepo.findFirstByBatchNameAndCustomerIdAndBatchIdNot(batch.getBatchName(), batch.getCustomerId(),
                batch.getBatchId());
        if(b != null){
            return Result.error("批次名称已存在");
        }
        int currentInSecond = TimeUtil.getCurrentInSecond();
        batch.setUpdateTime(currentInSecond);
         batchRepo.saveAndFlush(batch);
        return Result.success();
    }

    @Override
    public Result deleteBatch(String batchId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Batch>> getBatchList(String keyword, String customerId, String operateUserId) {
        List<Batch> batches = batchRepo.findAllByCustomerId(customerId);
        return Result.success(batches);
    }
    @Override
    public Result<BatchItem> addBatchItem(BatchItem batchItem, String operateUserId) {
        String batchId = batchItem.getBatchId();
        BatchItem b =batchItemRepo.findFirstByBatchIdAndItemId(batchId,batchItem.getItemId());
        if(b != null){
            return Result.error("自定义编号已存在");
        }

        b = batchItemRepo.getByTime(batchId, batchItem.getBeginTime(),batchItem.getEndTime());
        if(b != null){
            return Result.error("所选时间已存在自定义批次");
        }

        BatchItem newItem = batchItemRepo.saveAndFlush(batchItem);
        return Result.success(newItem);
    }
    @Transactional
    @Override
    public Result updateBatchItem(BatchItem batchItem, String operateUserId) {
        String batchId = batchItem.getBatchId();
        BatchItem b =batchItemRepo.findFirstByBatchIdAndItemIdAndIdNot(batchId,batchItem.getItemId(),batchItem.getId());
        if(b != null){
            return Result.error("自定义编号已存在");
        }
        int id = batchItem.getId();
        b = batchItemRepo.getByTimeNotId(batchId, batchItem.getBeginTime(),batchItem.getEndTime(),id);
        if(b != null){
            return Result.error("所选时间已存在自定义批次");
        }

       batchItemRepo.saveAndFlush(batchItem);
        return Result.success();
    }
    @Transactional
    @Override
    public Result deleteBatchItem(String itemId, String operateUserId) {
        batchItemRepo.deleteByItemId(itemId);
        return Result.success();
    }

    @Override
    public Result<PageList<BatchItem>> getBatchItemPageList(String keyword, String batchId, int page, int size, String operateUserId) {
        String sql = "SELECT * FROM batch_item WHERE batch_id=:batchId";
        Map<String,Object> param = new HashMap<>();
        param.put("batchId",batchId);
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (id LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "beginTime");
        Page<BatchItem> list = commonService.pageBySql(sql,param,pageable,BatchItem.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }

    @Override
    public Result<List<BatchItem>> getBatchItemList(String customerId, String operateUserId) {
        String sql = "SELECT * FROM batch_item WHERE batch_id like :k";
        Map<String,Object> param = new HashMap<>();
        param.put("k", customerId+"%");
        List<BatchItem> batchItems = commonService.listBySql(sql, param, BatchItem.class);

        return Result.success(batchItems);
    }
}
