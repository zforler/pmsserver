package com.wk.platform.equipment;

import com.wk.bean.Equipment;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentRepo equipmentRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;

    @Transactional
    @Override
    public Result<Equipment> addEquipment(Equipment equipment, String operateUserId) {
        String customerId = equipment.getCustomerId();
        Equipment old = equipmentRepo.findFirstByCustomerIdAndEquipmentName(customerId, equipment.getEquipmentName());
        if(old != null){
            return Result.error("设备名称重复");
        }

        String equipmentId = seqService.getNextBusinessId(Const.BZ_EQUIP, customerId, 4);
        equipment.setEquipmentId(equipmentId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        equipment.setCreateTime(currentInSecond);
        equipment.setUpdateTime(currentInSecond);
        equipment.setStatus(0);
        equipment.setSubCount(0);
        Equipment newEquip = equipmentRepo.saveAndFlush(equipment);

        return Result.success(newEquip);
    }
    @Transactional
    @Override
    public Result updateEquipment(Equipment equipment, String operateUserId) {
        String equipmentId = equipment.getEquipmentId();
        Equipment old = equipmentRepo.findFirstByEquipmentId(equipmentId);
        if(old == null){
            return Result.error("无此设备");
        }

        String customerId = equipment.getCustomerId();
        Equipment check = equipmentRepo.findFirstByCustomerIdAndEquipmentNameAndEquipmentIdNot(customerId
                , equipment.getEquipmentName(),equipmentId);
        if(check != null){
            return Result.error("设备名称重复");
        }

        int currentInSecond = TimeUtil.getCurrentInSecond();
        equipment.setUpdateTime(currentInSecond);
        equipment.setEquipmentType(old.getEquipmentType());
        equipment.setStatus(old.getStatus());
        equipment.setCreateTime(old.getCreateTime());
        equipment.setSubCount(old.getSubCount());
        Equipment newEquip = equipmentRepo.saveAndFlush(equipment);

        return Result.success(newEquip);
    }

    @Override
    public Result deleteEquipment(String equipmentId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<Equipment>> getEquipmentList(String keyword, int equipmentType,int status, String customerId, String operateUserId) {
        String sql = "SELECT * from equipment WHERE customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);

        if(equipmentType>0){
            sql += " AND equipment_type=:equipmentType";
            param.put("equipmentType",equipmentType);
        }
        if(status>0){
            sql += " AND status=:status";
            param.put("status",status);
        }
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (equipment_id LIKE :keyword OR equipment_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }


        List<Equipment> equipments = commonService.listBySql(sql, param, Equipment.class);

        return Result.success(equipments);
    }

    @Override
    public Result<Equipment> getEquipmentByEquipmentId(String equipmentId, String operateUserId) {
        Equipment old = equipmentRepo.findFirstByEquipmentId(equipmentId);
        return Result.success(old);
    }
}
