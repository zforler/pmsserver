package com.wk.platform.record;

import com.wk.bean.Record;

import java.util.List;
import java.util.Map;

public interface RecordService {
    List<Map<String,Object>> getReportList(String customerId,int beginTime,int endTime,String operateUserId);

    List<Map<String,Object>> getSalaryReportList(String customerId, int salaryType, int year, int month, int day,String operateUserId);

    List<Map<String,Object>> getProductionReportdList(String customerId,int beginTIme,int endTime,String operateUserId);

    List<Map<String,Object>> getYieldReportList(String customerId,int beginTIme,int endTime,String operateUserId);
}
