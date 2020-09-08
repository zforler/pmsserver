package com.wk.platform.record;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    @Override
    public List<Map<String, Object>> getReportList(String customerId, int beginTime, int endTime, String operateUserId) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getSalaryReportList(String customerId, int salaryType, int year, int month, int day, String operateUserId) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getProductionReportdList(String customerId, int beginTIme, int endTime, String operateUserId) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getYieldReportList(String customerId, int beginTIme, int endTime, String operateUserId) {
        return null;
    }
}
