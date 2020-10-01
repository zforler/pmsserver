package com.wk.platform.production;

import com.wk.bean.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductionRepo extends JpaRepository<Production,Integer> {
    Production findById(int id);
    Production findFirstByCustomerIdAndProductionNameAndEndTimeEquals(String customerId,String procutionName,int endTime);

    Production findFirstByCustomerIdAndProductionNameAndIdNotAndEndTimeEquals(String customerId,String procutionName,int id,int endTime);
    @Modifying
    @Query(value = "update production set end_time=?2 where id=?1",nativeQuery = true)
    int updateProductionEndTime(int id,int endTime);

    List<Production> findAllByCustomerId(String customerId);
    List<Production> findAllByCustomerIdAndEndTime(String customerId,int endTime);

    int countByCustomerIdAndEndTime(String customerId, int endTime);
}
