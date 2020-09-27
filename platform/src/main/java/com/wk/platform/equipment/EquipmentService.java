package com.wk.platform.equipment;

import com.wk.bean.Equipment;
import com.wk.bean.SubEquipment;
import com.wk.common.vo.Result;

import java.util.List;

public interface EquipmentService {
    Result<Equipment> addEquipment(Equipment equipment, String operateUserId);

    Result updateEquipment(Equipment equipment,String operateUserId);

    Result deleteEquipment(String equipmentId,String operateUserId);

    Result<List<Equipment>> getEquipmentList(String keyword,int equipmentType,int status, String customerId, String operateUserId);

    Result<Equipment> getEquipmentByEquipmentId(String equipmentId, String operateUserId);

    Result<List<SubEquipment>> getSubEquipmentList(String equipmentTypes, String customerId, String operateUserId);
}
