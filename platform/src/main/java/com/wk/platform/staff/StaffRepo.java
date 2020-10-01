package com.wk.platform.staff;

import com.wk.bean.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepo extends JpaRepository<Staff,String> {
    @Query(value = "SELECT s.*,sd.department_id departmentId FROM staff s LEFT JOIN staff_depart sd ON s.staff_id=sd.staff_id AND sd.end_time=0" +
            " WHERE s.staff_id=?1",nativeQuery = true)
    Staff getStaffByStaffId(String staffId);
    Staff findFirstByStaffId(String staffId);
    @Modifying
    @Query(value = "update staff set status=?2 where staff_id=?1",nativeQuery = true)
    void updatStaffStatus(String staffId,int status);

    Staff findFirstByStaffIdAndCustomerId(String staffId,String customerId);
    Staff findFirstByStaffNoAndCustomerId(String staffNo,String customerId);
    Staff findFirstByStaffNoAndCustomerIdAndStaffIdNot(String staffNo,String customerId,String staffId);

    int countByCustomerIdAndStatus(String customerId,int status);

}
