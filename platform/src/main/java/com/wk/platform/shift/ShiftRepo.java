package com.wk.platform.shift;

import com.wk.bean.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShiftRepo extends JpaRepository<Shift,Integer> {
    Shift findFirstById(int shiftId);
    Shift findFirstByCustomerIdAndShiftName(String customerId,String shiftName);
    Shift findFirstByCustomerIdAndShiftNameAndShiftIdNot(String customerId,String shiftName,String shiftId);
    List<Shift> findAllByCustomerIdAndReactiveTimeOrderByBeginTimeAsc(String customerId,int endTime);
    List<Shift> findAllByCustomerIdAndReactiveTimeAndIdNotOrderByBeginTimeAsc(String customerId,int endTime,int id);
    List<Shift> findAllByShiftId(String shiftId);
}
