package com.wk.platform.spec;

import com.wk.bean.Spec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SpecRepo extends JpaRepository<Spec,Integer> {
    Spec findFirstById(int id);

    Spec findByProductionIdAndSpecNameAndEndTimeEquals(String productionId,String specName,int endTime);
    Spec findByProductionIdAndSpecNameAndIdNotAndEndTimeEquals(String productionId,String specName,int id,int endTime);
    @Modifying
    @Query(value = "update spec set end_time=?2 where id=?1",nativeQuery = true)
    int updateSpecEndTime(int id,int endTime);
}
