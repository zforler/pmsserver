package com.wk.platform.record;

import com.wk.bean.Record;
import com.wk.common.vo.Result;

import java.util.List;
import java.util.Map;

public interface RecordService {
    Result<List<Map<String,Object>>> getRecordList(String customerId, int beginTime, int endTime, String operateUserId);

    Result<List<Map<String,Object>>> getSalaryReportList(String customerId,int beginTime, int endTime, String operateUserId);

    Result<List<Map<String,Object>>> getMonthSalaryReportList(String customerId,int beginTime, int endTime, String operateUserId);


    Result<List<Map<String,Object>>> getProductionReportdList(String customerId,int beginTIme,int endTime,String operateUserId);

    Result<List<Map<String,Object>>> getYieldReportList(String customerId,int beginTIme,int endTime,String operateUserId);
}
