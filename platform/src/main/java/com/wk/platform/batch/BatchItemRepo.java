package com.wk.platform.batch;

import com.wk.bean.BatchItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BatchItemRepo extends JpaRepository<BatchItem,String> {
    void deleteByItemId(String itemId);
    BatchItem findFirstByBatchIdAndItemId(String batchId,String itemId);
    BatchItem findFirstByBatchIdAndItemIdAndIdNot(String batchId,String itemId,int id);

    @Query(value = "SELECT * FROM batch_item WHERE batch_id=?1 and ((begin_time<=?2 AND end_time>?2) OR (begin_time<?3 AND end_time>=?3)" +
            " OR (begin_time>=?2 && begin_time<?3) OR (end_time>?2 AND end_time<=?3)) limit 1",nativeQuery = true)
    BatchItem getByTime(String batchId,int beginTime,int endTime);



    @Query(value = "SELECT * FROM batch_item WHERE batch_id=?1 and ((begin_time<=?2 AND end_time>?2) OR (begin_time<?3 AND end_time>=?3)"+
            " OR (begin_time>=?2 && begin_time<?3) OR (end_time>?2 AND end_time<=?3)) and id!=?4  limit 1",nativeQuery = true)
    BatchItem getByTimeNotId(String batchId,int beginTime,int endTime,int id);
}
