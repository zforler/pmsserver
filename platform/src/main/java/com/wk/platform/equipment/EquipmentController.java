package com.wk.platform.equipment;

import com.wk.bean.Equipment;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import com.wk.platform.equipment.EquipmentService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EquipmentController {
    private final Logger logger = LoggerFactory.getLogger(EquipmentController.class);
    @Autowired
    private EquipmentService equipmentService;

    @ApiOperation("添加设备")
    @PostMapping("/equipment")
    public Result<Equipment> addEquipment(Equipment equipment, String operateUserId){
        try {
            Result<Equipment> result = equipmentService.addEquipment(equipment, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改设备")
    @PostMapping("/updateEquipment")
    public Result<Equipment> updateEquipment(Equipment equipment, String operateUserId){
        try {
            Result<Equipment> result = equipmentService.updateEquipment(equipment, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除设备")
    @PostMapping("/deleteEquipment")
    public Result<Equipment> deleteEquipment(String equipmentId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Equipment> result = equipmentService.deleteEquipment(equipmentId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下设备列表")
    @GetMapping("/getEquipmentList")
    public Result<List<Equipment>> getEquipmentList(String keyword,
                                                    @RequestParam(required = false,defaultValue = "-1") int equipmentType,
                                                    @RequestParam(required = false,defaultValue = "-1") int status,
                                                    String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return equipmentService.getEquipmentList(keyword,equipmentType,status,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取设备详情")
    @GetMapping("/getEquipmentByEquipmentId")
    public Result<Equipment> getEquipmentByEquipmentId(String equipmentId, String operateUserId){
        try {
            Result<Equipment> result = equipmentService.getEquipmentByEquipmentId(equipmentId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
