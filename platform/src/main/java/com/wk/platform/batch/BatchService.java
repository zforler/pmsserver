package com.wk.platform.batch;

import com.wk.bean.Batch;
import com.wk.bean.BatchItem;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

import java.util.List;

public interface BatchService {
    Result<Batch> addBatch(Batch batch, String operateUserId);

    Result updateBatch(Batch batch,String operateUserId);

    Result deleteBatch(String batchId,String operateUserId);

    Result<List<Batch>> getBatchList(String keyword, String customerId, String operateUserId);

    Result<BatchItem> addBatchItem(BatchItem batchItem, String operateUserId);
    Result updateBatchItem(BatchItem batchItem, String operateUserId);
    Result deleteBatchItem(String itemId, String operateUserId);
    Result<PageList<BatchItem>> getBatchItemPageList(String keyword, String batchId, int page, int size, String operateUserId);
    Result<List<BatchItem>> getBatchItemList(String customerId, String operateUserId);
}
