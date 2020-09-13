package com.wk.platform.salaryAdjust;

import com.wk.bean.SalaryAdjustLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryAdjustLogRepo extends JpaRepository<SalaryAdjustLog,Integer> {
}
