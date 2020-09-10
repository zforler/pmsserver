package com.wk.platform.subEquipment;

import com.wk.bean.SubEquipment;
import com.wk.bean.SubEquipmentCalcLog;
import com.wk.common.vo.Result;

import java.util.List;
import java.util.Map;

public interface SubEquipmentService {
    Result<SubEquipment> addSubEquipment(SubEquipment subEquipment, String operateUserId);

    Result updateSubEquipment(SubEquipment subEquipment,String operateUserId);

    Result deleteSubEquipment(String subEquipmentId,String operateUserId);

    Result<List<SubEquipment>> getSubEquipmentList(String keyword,String equipmentId,  String customerId, String operateUserId);

    Result calcSwitch(String subEquipmentId,int type,int status,String customerId, String operateUserId);

    Result<Map<String,List<SubEquipmentCalcLog>>> getSubEquipmentCalcLogList(String subEquipmentId, String customerId
            , String operateUserId);
}
