package com.wk.platform.repo;

import com.wk.bean.StaffDepart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StaffDepartRepo extends JpaRepository<StaffDepart,Integer> {
    @Modifying
    @Query(value = "update staff_depart set end_time=?3 where staff_id=?1 and department_id=?2 and end_time=0",nativeQuery = true)
    int updateEndTime(String staffId,String departId,int endTime);

    @Modifying
    @Query(value = "update staff_depart set end_time=?2 where id=?1",nativeQuery = true)
    int updateEndTimeById(int id,int endTime);

    StaffDepart findFirstByStaffIdAndEndTimeEquals(String staffId,int endTime);
}
