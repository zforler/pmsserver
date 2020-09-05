package com.wk.platform.equipment;

import com.wk.bean.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EquipmentRepo extends JpaRepository<Equipment,String> {
    Equipment findFirstByEquipmentId(String equipId);

    Equipment findFirstByCustomerIdAndEquipmentName(String customerId,String equipmentName);

    Equipment findFirstByCustomerIdAndEquipmentNameAndEquipmentIdNot(String customerId,String equipmentName,String equipId);
    @Modifying
    @Query(value = "update equipment set sub_count=sub_count+?2 where equipment_id=?1",nativeQuery = true)
    int updateSubCount(String equipmentId,int count);
}
