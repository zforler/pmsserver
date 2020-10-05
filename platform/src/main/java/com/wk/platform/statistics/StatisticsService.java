package com.wk.platform.statistics;

import com.wk.common.vo.Result;

import java.util.Map;

public interface StatisticsService {
    Result<Integer> getStaffCount(String customerId,String operateUserId);
    Result<Integer> getProductionCount(String customerId,String operateUserId);
    Result<Integer> getEquipmentCount(String customerId,String operateUserId);
    Result<Map<String,Object>> getProductionSummary(String customerId, String operateUserId);
    Result<Map<String,Object>> getProductionSummaryEveryDay(String customerId, int beginTime,int endTime,String operateUserId);
    Result<Map<String,Object>> getProductionSummaryMonth(String customerId, int beginTime,int endTime,String operateUserId);
}
