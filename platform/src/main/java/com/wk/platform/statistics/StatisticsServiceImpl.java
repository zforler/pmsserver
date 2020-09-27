package com.wk.platform.statistics;

import com.wk.common.vo.Result;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Override
    public Result<Integer> getStaffCount(String customerId, String operateUserId) {
        return null;
    }

    @Override
    public Result<Integer> getProductionCount(String customerId, String operateUserId) {
        return null;
    }

    @Override
    public Result<Integer> getEquipmentCount(String customerId, String operateUserId) {
        return null;
    }

    @Override
    public Result<Map<String, Integer>> getProductionSummary(String customerId, String operateUserId) {
        return null;
    }
}
