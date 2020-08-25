package com.wk.platform.repo;

import com.wk.bean.StaffDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StaffDepartRepo extends JpaRepository<StaffDepart,Integer> {
    @Query(value = "update staff_depart set end_time=?3 where staff_id=?1 and department_id=?2 and end_time=0",nativeQuery = true)
    void updateEndTime(String staffId,String departId,int endTime);
}
