package com.wk.platform.salaryAdjust;

import com.wk.bean.SalaryAdjustLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryAdjustLogRepo extends JpaRepository<SalaryAdjustLog,Integer> {
    List<SalaryAdjustLog> findAllByStaffNoInAndYearAndMonthAndDay(List<String> staffNos,int year,int month,int day);
    List<SalaryAdjustLog> findAllByStaffNoAndYearAndMonthAndDay(String staffNo,int year,int month,int day);
}
