package com.wk.platform.record;

import com.wk.bean.SalaryAdjustLog;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.platform.salaryAdjust.SalaryAdjustLogRepo;
import com.wk.platform.staff.StaffRepo;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private RecordRepo recordRepo;
    @Autowired
    private StaffRepo staffRepo;
    @Autowired
    private SalaryAdjustLogRepo salaryAdjustLogRepo;

    @Override
    public Result<List<Map<String,Object>>> getRecordList(String customerId, int beginTime, int endTime, String operateUserId) {
        String sql = "SELECT * FROM record WHERE customer_id=:customerId ";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(beginTime>-1){
            sql += " AND calc_time>=:beginTime";
            param.put("beginTime",beginTime);
        }
        if(endTime>-1){
            sql += " AND calc_time<:endTime";
            param.put("endTime",endTime);
        }
        List<Map<String, Object>> record = commonService.nativeQuery4Map(sql, param);
        return Result.success(record);
    }

    @Override
    public Result<List<Map<String,Object>>> getSalaryReportList(String keyword,String customerId,int beginTime, int endTime,
                                                                String operateUserId) {

        String sql = "SELECT r.staff_no,s.staff_name,s.staff_type,department_name,production_name,spec_name,technology_name," +
                "record_time,SUM(total_price) total_price,0 adjust,0 subsidy,r.year,r.month,r.day FROM record r" +
                " LEFT JOIN staff s ON r.staff_no=s.staff_no" +
                " WHERE r.customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(beginTime, 0, OffsetDateTime.now().getOffset());
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        param.put("year", year);
        param.put("month", month);
        param.put("day", day);
        sql += " AND r.year=:year AND r.month=:month AND r.day=:day";
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND s.staff_name LIKE :keyword";
            param.put("keyword", "%"+keyword+"%");
        }

        sql += " GROUP BY staff_no";
        List<Map<String, Object>> records = commonService.nativeQuery4Map(sql, param);

        if(records == null || records.size()==0){
            return  Result.success(records);
        }
        List<String> staffNos = records.stream().map(t -> String.valueOf(t.get("staff_no"))).collect(Collectors.toList());
        List<SalaryAdjustLog> salaryAdjustLogs = salaryAdjustLogRepo.findAllByStaffNoInAndYearAndMonthAndDay(staffNos,
                year, month, day);
        if(salaryAdjustLogs != null && salaryAdjustLogs.size()>0){
            Map<String, Object> record = null;
            for (int i = 0, size = records.size(); i < size; i++) {
                record = records.get(i);
                record.get("staff_no");
                Iterator<SalaryAdjustLog> iterator = salaryAdjustLogs.iterator();
                while (iterator.hasNext()){
                    SalaryAdjustLog salaryAdjustLog = iterator.next();
                    if(record.get("staff_no").equals(salaryAdjustLog.getStaffNo())){
                        if(record.get("adjustLogs") == null){
                            List<SalaryAdjustLog> adjustLogs = new ArrayList<>();
                            record.put("adjustLogs",adjustLogs);
                        }
                        ((List)record.get("adjustLogs")).add(salaryAdjustLog);
                        record.put("adjust",Integer.valueOf(String.valueOf(record.get("adjust")))+salaryAdjustLog.getAdjust());
                        record.put("subsidy",Integer.valueOf(String.valueOf(record.get("subsidy")))+salaryAdjustLog.getSubsidy());
                        iterator.remove();
                    }
                }
            }
        }

        return Result.success(records);
    }

    @Override
    public Result<List<Map<String, Object>>> getMonthSalaryReportList(String customerId, int beginTime, int endTime, String operateUserId) {
        String sql = "SELECT staff_no,staff_name,department_name,SUM(total_price) total_price" +
                " FROM record WHERE customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(beginTime>-1){
            sql += " AND calc_time>=:beginTime";
            param.put("beginTime",beginTime);
        }
        if(endTime>-1){
            sql += " AND calc_time<:endTime";
            param.put("endTime",endTime);
        }
        sql += " GROUP BY staff_no";
        List<Map<String, Object>> record = commonService.nativeQuery4Map(sql, param);
        return Result.success(record);
    }

    @Override
    public Result<List<Map<String,Object>>> getProductionReportdList(String customerId, int beginTime, int endTime, String operateUserId) {
        String sql = "SELECT production_name,batch_name,spec_name,technology_name,record_time,SUM(delivery_kg) delivery_kg FROM" +
                " record WHERE customer_id=:customerId ";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(beginTime>-1){
            sql += " AND calc_time>=:beginTime";
            param.put("beginTime",beginTime);
        }
        if(endTime>-1){
            sql += " AND calc_time<:endTime";
            param.put("endTime",endTime);
        }
        sql += " GROUP BY production_name,batch_name,spec_name,technology_name";
        List<Map<String, Object>> record = commonService.nativeQuery4Map(sql, param);
        return Result.success(record);
    }

    @Override
    public Result<List<Map<String,Object>>> getYieldReportList(String customerId, int beginTime, int endTime, String operateUserId) {
        String sql = "SELECT staff_no,staff_name,department_name, production_name,spec_name,technology_name," +
                "SUM(dispatch_kg) dispatch_kg,SUM(delivery_kg) delivery_kg, 0 yield_t FROM record WHERE customer_id=:customerId ";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(beginTime>-1){
            sql += " AND calc_time>=:beginTime";
            param.put("beginTime",beginTime);
        }
        if(endTime>-1){
            sql += " AND calc_time<:endTime";
            param.put("endTime",endTime);
        }
        sql += " GROUP BY staff_no";
        List<Map<String, Object>> record = commonService.nativeQuery4Map(sql, param);
        return Result.success(record);
    }

    @Override
    public Result<List<Map<String, Object>>> getStaffDayRecordList(String customerId, String staffNo, int year, int month,
                                                                   int day, String operateUserId) {
        String sql = "SELECT r.staff_no,s.staff_name,s.staff_type,department_name,production_name,spec_name,technology_name," +
                "r.price_type,r.dispatch_kg,r.delivery_kg,r.delivery_count,record_time,r.price,r.total_price,r.year," +
                "r.month,r.day FROM record r LEFT JOIN staff s ON r.staff_no=s.staff_no" +
                " WHERE r.staff_no=:staffNo AND r.year=:year AND r.month=:month AND r.day=:day";
        Map<String,Object> param = new HashMap<>();
        param.put("staffNo",staffNo);
        param.put("year", year);
        param.put("month", month);
        param.put("day", day);

        List<Map<String, Object>> records = commonService.nativeQuery4Map(sql, param);
        return Result.success(records);
    }
}
