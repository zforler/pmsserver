package com.wk.platform.record;

import com.wk.bean.SalaryAdjustLog;
import com.wk.common.constant.Const;
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
    public Result<List<Map<String,Object>>> getRecordList(String customerId, int beginTime, int endTime, String keyword,
                                                          String subEquipmentId,String departmentId,int priceType,
                                                          String operateUserId) {
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
        if(StringUtils.isNotBlank(subEquipmentId)){
            sql += " AND (dispatch_sub_id=:subEquipmentId OR delivery_sub_id=:subEquipmentId OR sign_sub_id=:subEquipmentId)";
            param.put("subEquipmentId",subEquipmentId);
        }
        if(StringUtils.isNotBlank(departmentId)){
            sql += " AND (department_id=:departmentId)";
            param.put("departmentId",departmentId);
        }
        if(priceType>-1){
            sql += " AND price_type=:priceType";
            param.put("priceType",priceType);
        }
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (staff_no LIKE :keyword OR staff_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<Map<String, Object>> record = commonService.nativeQuery4Map(sql, param);
        return Result.success(record);
    }

    @Override
    public Result<List<Map<String,Object>>> getSalaryReportList(String keyword,String customerId,int beginTime, int endTime,
                                                                String operateUserId) {

        String sql = "SELECT r.staff_no,s.staff_name,s.staff_type,department_name,price_type,total_price,0 kg_salary," +
                "0 count_salary,0 time_salary,0 adjust,0 subsidy,r.year,r.month,r.day FROM record r" +
                " LEFT JOIN staff s ON r.staff_no=s.staff_no  WHERE r.customer_id=:customerId";
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
            sql += " AND (s.staff_name LIKE :keyword OR s.staff_no LIKE :keyword)";
            param.put("keyword", "%"+keyword+"%");
        }

        List<Map<String, Object>> records1 = commonService.nativeQuery4Map(sql, param);
        if(records1.size()==0){
            return  Result.success(records1);
        }

        List<Map<String, Object>> records = new ArrayList<>();
        Map<String,Map<String, Object>> tmap = new HashMap<>();
        Map<String, Object> temp = null;
        for (int i = 0, len = records1.size(); i < len; i++) {
            temp = records1.get(i);
            String staffNo = String.valueOf(temp.get("staff_no"));
            float priceType = Float.valueOf(String.valueOf(temp.get("price_type")));
            float totalPrice = Float.valueOf(String.valueOf(temp.get("total_price")));
            if(!tmap.containsKey(staffNo)){
                tmap.put(staffNo,temp);
                records.add(temp);
                if(priceType == Const.PRICE_TYPE_WEIGHT){
                    temp.put("kg_salary",totalPrice);
                }else if(priceType == Const.PRICE_TYPE_COUNT){
                    temp.put("count_salary",totalPrice);
                }else if(priceType == Const.PRICE_TYPE_TIME){
                    temp.put("time_salary",totalPrice);
                }
            }else{
                Map<String, Object> prev = tmap.get(staffNo);
                if(priceType == Const.PRICE_TYPE_WEIGHT){
                    prev.put("kg_salary", Float.valueOf(String.valueOf(prev.get("kg_salary")))+totalPrice);
                }else if(priceType == Const.PRICE_TYPE_COUNT){
                    prev.put("count_salary", Float.valueOf(String.valueOf(prev.get("count_salary")))+totalPrice);
                }else if(priceType == Const.PRICE_TYPE_TIME){
                    prev.put("time_salary", Float.valueOf(String.valueOf(prev.get("time_salary")))+totalPrice);
                }
                prev.put("total_price", Float.valueOf(String.valueOf(prev.get("kg_salary")))
                        +Float.valueOf(String.valueOf(prev.get("count_salary")))
                        +Float.valueOf(String.valueOf(prev.get("time_salary"))));
            }
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
