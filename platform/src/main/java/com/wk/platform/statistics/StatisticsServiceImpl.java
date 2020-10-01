package com.wk.platform.statistics;

import com.wk.common.constant.Const;
import com.wk.common.vo.Result;
import com.wk.platform.production.ProductionRepo;
import com.wk.platform.staff.StaffRepo;
import com.wk.platform.subEquipment.SubEquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private ProductionRepo productionRepo;
    @Autowired
    private SubEquipmentRepo subEquipmentRepo;

    @Override
    public Result<Integer> getStaffCount(String customerId, String operateUserId) {
        int count = staffRepo.countByCustomerIdAndStatus(customerId, Const.STAFF_STATUS_NORMAL);
        return Result.success(count);
    }

    @Override
    public Result<Integer> getProductionCount(String customerId, String operateUserId) {
        int count = productionRepo.countByCustomerIdAndEndTime(customerId, 0);
        return Result.success(count);
    }

    @Override
    public Result<Integer> getEquipmentCount(String customerId, String operateUserId) {
        int count = subEquipmentRepo.countBySubEquipmentIdLike(customerId);
        return Result.success(count);
    }

    @Override
    public Result<Map<String, Integer>> getProductionSummary(String customerId, String operateUserId) {
        return null;
    }
}
