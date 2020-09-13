package com.wk.platform.record;

import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private CommonService commonService;
    @Autowired
    private RecordRepo recordRepo;
    
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
    public Result<List<Map<String,Object>>> getSalaryReportList(String customerId,int beginTime, int endTime, String operateUserId) {
        String sql = "SELECT staff_no,staff_name,department_name,production_name,spec_name,technology_name," +
                "record_time,SUM(total_price) total_price FROM record WHERE customer_id=:customerId";
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
}
