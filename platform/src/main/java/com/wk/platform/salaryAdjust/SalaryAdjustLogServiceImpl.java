package com.wk.platform.salaryAdjust;

import com.wk.bean.SalaryAdjustLog;
import com.wk.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryAdjustLogServiceImpl implements SalaryAdjustLogService {
    @Autowired
    private SalaryAdjustLogRepo salaryAdjustLogRepo;

    @Override
    public Result<SalaryAdjustLog> addSalaryAdjustLog(SalaryAdjustLog salaryAdjustLog, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<SalaryAdjustLog>> getSalaryAdjustLogList(String customerId, String staffNo, int year, int month, int day, String operateUserId) {
        return null;
    }
}
