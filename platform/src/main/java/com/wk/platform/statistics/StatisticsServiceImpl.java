package com.wk.platform.statistics;

import com.wk.common.constant.Const;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.platform.production.ProductionRepo;
import com.wk.platform.staff.StaffRepo;
import com.wk.platform.subEquipment.SubEquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.util.*;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private ProductionRepo productionRepo;
    @Autowired
    private SubEquipmentRepo subEquipmentRepo;
    @Autowired
    private CommonService commonService;

    @Override
    public Result<Integer> getStaffCount(String customerId, String operateUserId) {
        Integer count = staffRepo.countByCustomerIdAndStatus(customerId, Const.STAFF_STATUS_NORMAL);
        return Result.success(count);
    }

    @Override
    public Result<Integer> getProductionCount(String customerId, String operateUserId) {
        Integer count = productionRepo.countByCustomerIdAndEndTime(customerId, 0);
        return Result.success(count);
    }

    @Override
    public Result<Integer> getEquipmentCount(String customerId, String operateUserId) {
        Integer count = subEquipmentRepo.countBySubEquipmentIdLike(customerId);
        return Result.success(count);
    }

    @Override
    public Result<Map<String, Object>> getProductionSummary(String customerId, String operateUserId) {
        String sql = "SELECT SUM(delivery_kg) dispatch_kg FROM record WHERE customer_id=:customerId AND price_type=1";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        Map<String, Object> maps = commonService.nativeQuery4OneMap(sql, param);
        return Result.success(maps);
    }

    @Override
    public Result<Map<String, Object>> getProductionSummaryEveryDay(String customerId, int beginTime, int endTime, String operateUserId) {
        int endTime0 = endTime;
        if (endTime0 < 0) {
            endTime0 = (int)LocalDateTime.now().toEpochSecond(OffsetDateTime.now().getOffset());
        }
        int beginTime0 = beginTime;
        if (beginTime0 < 0) {
            beginTime0 = endTime0 - 30 * 86400;
        }
        String sql = "SELECT production_name,`year`,`month`,`day`,SUM(delivery_kg) delivery_kg FROM record " +
                "WHERE customer_id=:customerId AND price_type=1 AND calc_time>=:beginTime AND calc_time<:endTime" +
                " GROUP BY production_name,`year`,`month`,`day` order by year,month,day asc";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        param.put("beginTime",beginTime0);
        param.put("endTime",endTime0);
        List<Map<String, Object>> maps = commonService.nativeQuery4Map(sql, param);
        Map<String,Object> res = new HashMap<>();
        res.put("x", getDayList());
        res.put("data", maps);
        return Result.success(res);
    }

    @Override
    public Result<Map<String, Object>> getProductionSummaryMonth(String customerId, int beginTime, int endTime, String operateUserId) {
        int endTime0 = endTime;
        if (endTime0 < 0) {
            endTime0 = (int)LocalDateTime.now().toEpochSecond(OffsetDateTime.now().getOffset());
        }
        int beginTime0 = beginTime;
        if (beginTime0 < 0) {
            beginTime0 = endTime0 - 30 * 86400;
        }
        String sql = "SELECT production_name,`year`,`month`,SUM(delivery_kg) delivery_kg FROM record " +
                "WHERE customer_id=:customerId AND price_type=1 AND calc_time>=:beginTime AND calc_time<:endTime" +
                " GROUP BY production_name,`year`,`month` order by year,month asc";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        param.put("beginTime",beginTime0);
        param.put("endTime",endTime0);
        List<Map<String, Object>> maps = commonService.nativeQuery4Map(sql, param);
        Map<String,Object> res = new HashMap<>();
        res.put("x", getMonthList());
        res.put("data", maps);
        return Result.success(res);
    }


    public List<String> getDayList(){
        LocalDate now = LocalDate.now();
        List<String> days = new ArrayList<>();
        for (int i = 0; i < 30 ; i++) {
            days.add(String.format("%s/%s",now.getMonthValue(),now.getDayOfMonth()));
            now = now.minusDays(1);
        }
        Collections.reverse(days);
        return days;
    }
    public List<String> getMonthList(){
        LocalDate now = LocalDate.now();
        List<String> months = new ArrayList<>();
        for (int i = 0; i < 12 ; i++) {
            months.add(String.format("%s/%s",now.getYear(),now.getMonthValue()));
            now = now.minusMonths(1);
        }
        Collections.reverse(months);
        return months;
    }
}
