package com.wk.platform.recordEdit;

import com.wk.bean.Record;
import com.wk.bean.RecordEditLog;
import com.wk.bean.RecordOld;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.platform.production.ProductionRepo;
import com.wk.platform.record.RecordRepo;
import com.wk.platform.spec.SpecRepo;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.Time;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class RecordEditLogServiceImpl implements RecordEditLogService {
    @Autowired
    private RecordOldRepo recordOldRepo;
    @Autowired
    private RecordEditLogRepo recordEditLogRepo;
    @Autowired
    private RecordRepo recordRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private ProductionRepo productionRepo;
    @Autowired
    private SpecRepo specRepo;



    @Transactional
    @Override
    public Result<RecordEditLog> addRecordEditLog(RecordEditLog recordEditLog, String operateUserId) {

        int second = TimeUtil.getCurrentInSecond();
        recordEditLog.setUpdateTime(second);
        recordEditLog.setOperateUserId(operateUserId);


        String customerId = recordEditLog.getCustomerId();
        String subEquipmentId = recordEditLog.getSubEquipmentId();
        Integer beginTime = recordEditLog.getBeginTime();
        Integer endTime = recordEditLog.getEndTime();
        String oldProductionId = recordEditLog.getOldProductionId();
        String oldBatchId = recordEditLog.getOldBatchId();
        String oldTechnologyId = recordEditLog.getOldTechnologyId();
        String oldSpecId = recordEditLog.getOldSpecId();
        int newPrice = Optional.ofNullable(recordEditLog.getNewPrice()).orElse(0);


        RecordEditLog recordEditLog1 = recordEditLogRepo.saveAndFlush(recordEditLog);


        String sql = "SELECT * FROM record WHERE customer_id=:customerId AND delivery_sub_id=:deliverySubId" +
                " AND record_time>=:beginTime AND record_time<:endTime AND production_id=:oldProductionId" +
                " AND technology_id=:oldTechnologyId AND spec_id=:oldSpecId";

        Map<String,Object> params = new HashMap<>();
        params.put("customerId", customerId);
        params.put("deliverySubId", subEquipmentId);
        params.put("beginTime", beginTime);
        params.put("endTime", endTime);
        params.put("oldProductionId", oldProductionId);
        params.put("oldTechnologyId", oldTechnologyId);
        params.put("oldSpecId", oldSpecId);
        if(StringUtils.isNotBlank(oldBatchId)){
            sql += " AND batch_id=:oldBatchId";
            params.put("oldBatchId", oldBatchId);
        }

        List<Record> records = commonService.listBySql(sql, params, Record.class);

        if(records.size() == 0){
            return Result.error("未查询到相关记录");
        }
        Record record = null;
        BigDecimal b100 = new BigDecimal(100);
        List<RecordOld> recordOlds = new ArrayList<>();

        String newProductionId = recordEditLog.getNewProductionId();
        String newBatchId = recordEditLog.getNewBatchId();
        String newTechnologyId = recordEditLog.getNewTechnologyId();
        String newSpecId = recordEditLog.getOldSpecId();
        for (int i = 0, size = records.size(); i < size; i++) {
            record = records.get(i);
            RecordOld recordOld = new RecordOld();
            BeanUtils.copyProperties(record, recordOld);
            recordOlds.add(recordOld);


            record.setBatchId(newBatchId);
            record.setProductionId(newProductionId);
            record.setTechnologyId(newTechnologyId);
            record.setSpecId(newSpecId);
            record.setAppend(String.valueOf(recordEditLog1.getId()));
            if(record.getPrice().intValue() != newPrice){
                record.setPrice(new BigDecimal(newPrice));
                if(record.getPriceType() == Const.PRICE_TYPE_WEIGHT){
                    BigDecimal price = record.getDeliveryKg().multiply(new BigDecimal(newPrice).divide(b100));
                    record.setTotalPrice(price);
                }else if(record.getPriceType() == Const.PRICE_TYPE_COUNT){
                    BigDecimal price = record.getDeliveryCount().multiply(new BigDecimal(newPrice).divide(b100));
                    record.setTotalPrice(price);
                }
            }

        }
        recordRepo.saveAll(records);
        recordOldRepo.saveAll(recordOlds);


        return Result.success(String.format("成功修改%d条记录",records.size()));
    }


    @Override
    public Result<List<RecordEditLog>> getRecordEditLogList(String keyword, String customerId, String operateUserId) {
        String sql = "SELECT rel.*,ui.user_name FROM record_edit_log rel left join user_info ui on rel.operate_user_id=ui.user_id" +
                " WHERE rel.customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (old_batch_name LIKE :keyword OR old_production_name LIKE :keyword OR old_technology_name LIKE :keyword " +
                    "OR old_spec_id LIKE :keyword OR new_batch_name :keyword OR new_production_name LIKE :keyword" +
                    " OR new_technology_name LIKE :keyword OR new_spec_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        List<RecordEditLog> recordEditLogs = commonService.listBySql(sql, param, RecordEditLog.class);

        return Result.success(recordEditLogs);
    }

    @Override
    public Result<PageList<RecordEditLog>> getRecordEditLogPageList(String keyword, String customerId, int page,
                                                                    int size, String operateUserId) {
        String sql = "SELECT rel.*,ui.user_name FROM record_edit_log rel left join user_info ui on rel.operate_user_id=ui.user_id" +
                " WHERE rel.customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (old_batch_name LIKE :keyword OR old_production_name LIKE :keyword OR old_technology_name LIKE :keyword " +
                    "OR old_spec_id LIKE :keyword OR new_batch_name LIKE :keyword OR new_production_name LIKE :keyword" +
                    " OR new_technology_name LIKE :keyword OR new_spec_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "update_time");
        Page<RecordEditLog> list = commonService.pageBySql(sql,param,pageable,RecordEditLog.class);

        return Result.success(new PageList<>(list.getContent(),list.getTotalElements(),page,size));
    }
}
