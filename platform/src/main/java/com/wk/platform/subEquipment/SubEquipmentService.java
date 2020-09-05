package com.wk.platform.subEquipment;

import com.wk.bean.SubEquipment;
import com.wk.common.vo.Result;

import java.util.List;

public interface SubEquipmentService {
    Result<SubEquipment> addSubEquipment(SubEquipment subEquipment, String operateUserId);

    Result updateSubEquipment(SubEquipment subEquipment,String operateUserId);

    Result deleteSubEquipment(String subEquipmentId,String operateUserId);

    Result<List<SubEquipment>> getSubEquipmentList(String keyword,String equipmentId,  String customerId, String operateUserId);

}
