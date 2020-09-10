package com.wk.platform.subEquipment;

import com.wk.bean.SubEquipmentCalcLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubEquipmentCalcLogRepo extends JpaRepository<SubEquipmentCalcLog,Integer> {
    SubEquipmentCalcLog findFirstBySubEquipmentIdAndTypeAndEndTime(String id,int type,int endTime);

    List<SubEquipmentCalcLog> findAllBySubEquipmentId(String id);
    List<SubEquipmentCalcLog> findAllBySubEquipmentIdAndType(String id,int type);
}
