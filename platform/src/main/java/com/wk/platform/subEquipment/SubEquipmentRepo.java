package com.wk.platform.subEquipment;

import com.wk.bean.SubEquipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubEquipmentRepo extends JpaRepository<SubEquipment,String> {
    SubEquipment findFirstByEquipmentIdAndSubEquipmentName(String equipmentId,String name);

    SubEquipment findFirstByEquipmentIdAndSubEquipmentNameAndSubEquipmentIdNot(String equipmentId,String name,String subId);

    SubEquipment findFirstBySubEquipmentId(String subId);

    int countBySubEquipmentIdLike(String customerId);
}
