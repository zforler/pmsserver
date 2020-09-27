package com.wk.platform.statistics;

import com.wk.common.vo.Result;

import java.util.Map;

public interface StatisticsService {
    Result<Integer> getStaffCount(String customerId,String operateUserId);
    Result<Integer> getProductionCount(String customerId,String operateUserId);
    Result<Integer> getEquipmentCount(String customerId,String operateUserId);
    Result<Map<String,Integer>> getProductionSummary(String customerId, String operateUserId);
}
