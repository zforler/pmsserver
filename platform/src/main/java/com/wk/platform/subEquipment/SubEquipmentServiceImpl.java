package com.wk.platform.subEquipment;

import com.wk.bean.SubEquipment;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.equipment.EquipmentRepo;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubEquipmentServiceImpl implements SubEquipmentService {
    @Autowired
    private SubEquipmentRepo subEquipmentRepo;
    @Autowired
    private EquipmentRepo equipmentRepo;
    @Autowired
    private CommonService commonService;
    @Autowired
    private SeqService seqService;

    @Transactional
    @Override
    public Result<SubEquipment> addSubEquipment(SubEquipment subEquipment, String operateUserId) {
        String equipmentId = subEquipment.getEquipmentId();
        SubEquipment old = subEquipmentRepo.findFirstByEquipmentIdAndSubEquipmentName(equipmentId, subEquipment.getSubEquipmentName());
        if(old != null){
            return Result.error("设备名称重复");
        }

        String subId = seqService.getNextBusinessId(Const.BZ_EQUIP_SUB, equipmentId, 2);
        subEquipment.setSubEquipmentId(subId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        subEquipment.setCreateTime(currentInSecond);
        subEquipment.setUpdateTime(currentInSecond);

        SubEquipment newSub = subEquipmentRepo.saveAndFlush(subEquipment);

        equipmentRepo.updateSubCount(equipmentId,1);

        return Result.success(newSub);
    }
    @Transactional
    @Override
    public Result updateSubEquipment(SubEquipment subEquipment, String operateUserId) {
        String equipmentId = subEquipment.getEquipmentId();
        SubEquipment old = subEquipmentRepo.findFirstBySubEquipmentId(subEquipment.getSubEquipmentId());
        if(old == null){
            return Result.error("设备不存在");
        }
        SubEquipment old1 = subEquipmentRepo.findFirstByEquipmentIdAndSubEquipmentNameAndSubEquipmentIdNot(equipmentId
                , subEquipment.getSubEquipmentName(),equipmentId);
        if(old1 != null){
            return Result.error("设备名称重复");
        }

        int currentInSecond = TimeUtil.getCurrentInSecond();
        subEquipment.setCreateTime(old.getCreateTime());
        subEquipment.setUpdateTime(currentInSecond);
        subEquipment.setType(old.getType());

        subEquipmentRepo.saveAndFlush(subEquipment);

        return Result.success();
    }

    @Override
    public Result deleteSubEquipment(String subEquipmentId, String operateUserId) {
        return null;
    }

    @Override
    public Result<List<SubEquipment>> getSubEquipmentList(String keyword,String equipmentId,  String customerId, String operateUserId) {
        String sql = "SELECT * from sub_equipment WHERE equipment_id=:equipmentId";
        Map<String,Object> param = new HashMap<>();
        param.put("equipmentId",equipmentId);

        List<SubEquipment> equipments = commonService.listBySql(sql, param, SubEquipment.class);

        return Result.success(equipments);
    }
}
