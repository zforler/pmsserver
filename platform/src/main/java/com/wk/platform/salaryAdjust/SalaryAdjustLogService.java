package com.wk.platform.salaryAdjust;

import com.wk.bean.SalaryAdjustLog;
import com.wk.common.vo.Result;

import java.util.List;

public interface SalaryAdjustLogService {
    Result<SalaryAdjustLog> addSalaryAdjustLog(SalaryAdjustLog salaryAdjustLog, String operateUserId);

    Result<List<SalaryAdjustLog>> getSalaryAdjustLogList(String customerId,String staffNo,int year,int month,int day,
                                                         String operateUserId);
}
