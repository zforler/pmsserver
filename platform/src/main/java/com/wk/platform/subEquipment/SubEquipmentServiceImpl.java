package com.wk.platform.subEquipment;

import com.wk.bean.SubEquipment;
import com.wk.bean.SubEquipmentCalcLog;
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

import java.util.*;

@Service
public class SubEquipmentServiceImpl implements SubEquipmentService {
    @Autowired
    private SubEquipmentRepo subEquipmentRepo;
    @Autowired
    private SubEquipmentCalcLogRepo subEquipmentCalcLogRepo;
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
        subEquipment.setStaffTypeCalc(Const.INACTIVE);
        subEquipment.setShiftCalc(Const.INACTIVE);
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
        subEquipment.setStaffTypeCalc(old.getStaffTypeCalc());
        subEquipment.setShiftCalc(old.getShiftCalc());

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
    @Transactional
    @Override
    public Result calcSwitch(String subEquipmentId, int type,int status, String customerId, String operateUserId) {
        SubEquipment sub = subEquipmentRepo.findFirstBySubEquipmentId(subEquipmentId);
        if(sub == null){
            return Result.error("终端不存在");
        }
        if(type == Const.CALC_STAFF_TYPE){
            if(status == sub.getStaffTypeCalc()){
                return Result.success();
            }
            sub.setStaffTypeCalc(status);
            subEquipmentRepo.saveAndFlush(sub);
        }else if(type == Const.CALC_SHIFT){
            if(status == sub.getShiftCalc()){
                return Result.success();
            }
            sub.setShiftCalc(status);
            subEquipmentRepo.saveAndFlush(sub);
        }else{
            return Result.error("类型错误");
        }
        return updateLog(subEquipmentId,type,status);
    }
    @Transactional
    public Result updateLog(String subEquipmentId,int type,int status){
        SubEquipmentCalcLog log = subEquipmentCalcLogRepo.findFirstBySubEquipmentIdAndTypeAndEndTime(subEquipmentId,
                type, 0);
        int second = TimeUtil.getCurrentInSecond();
        if(status == Const.INACTIVE){
            if(log == null){
                return Result.success();
            }else{
                log.setEndTime(second);
                subEquipmentCalcLogRepo.saveAndFlush(log);
            }
        }else if(status == Const.ACTIVE){
            if(log != null){
                return Result.success();
            }else{
                SubEquipmentCalcLog subEquipmentCalcLog = new SubEquipmentCalcLog();
                subEquipmentCalcLog.setSubEquipmentId(subEquipmentId);
                subEquipmentCalcLog.setBeginTime(second);
                subEquipmentCalcLog.setEndTime(0);
                subEquipmentCalcLog.setType(type);
                subEquipmentCalcLogRepo.saveAndFlush(subEquipmentCalcLog);
            }
        }
        return Result.success();
    }

    @Override
    public Result<Map<String,List<SubEquipmentCalcLog>>> getSubEquipmentCalcLogList(String subEquipmentId, String customerId
            , String operateUserId) {
        Map<String,List<SubEquipmentCalcLog>> map = new HashMap<>();
        List<SubEquipmentCalcLog> his1 = subEquipmentCalcLogRepo.findAllBySubEquipmentIdAndType(subEquipmentId,Const.CALC_STAFF_TYPE);
        map.put("his1", Optional.ofNullable(his1).orElse(new ArrayList<>()));
        List<SubEquipmentCalcLog> his2 = subEquipmentCalcLogRepo.findAllBySubEquipmentIdAndType(subEquipmentId,Const.CALC_SHIFT);
        map.put("his2", Optional.ofNullable(his2).orElse(new ArrayList<>()));
        return Result.success(map);
    }
}
