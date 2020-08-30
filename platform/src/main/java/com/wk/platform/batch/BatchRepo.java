package com.wk.platform.batch;

import com.wk.bean.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BatchRepo extends JpaRepository<Batch,String> {
    Batch findFirstByBatchNameAndCustomerId(String batchName,String customerId);

    Batch findFirstByBatchNameAndCustomerIdAndBatchIdNot(String batchName,String customerId,String batchId);

    List<Batch> findAllByCustomerId(String customerId);
}
