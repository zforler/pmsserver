package com.wk.platform.technology;

import com.wk.bean.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TechnologyRepo extends JpaRepository<Technology,Integer> {
    Technology findFirstById(int id);

    Technology findByProductionIdAndTechnologyNameAndEndTimeEquals(String productionId,String technologyName,int endTime);
    Technology findByProductionIdAndTechnologyNameAndIdNotAndEndTimeEquals(String productionId,String technologyName,int id,int endTime);
    @Modifying
    @Query(value = "update technology set end_time=?2 where id=?1",nativeQuery = true)
    int updateTechnologyEndTime(int id,int endTime);
}
