package com.wk.platform.subEquipment;

import com.wk.bean.SubEquipment;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import com.wk.platform.subEquipment.SubEquipmentController;
import com.wk.platform.subEquipment.SubEquipmentService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubEquipmentController {
    private final Logger logger = LoggerFactory.getLogger(SubEquipmentController.class);
    @Autowired
    private SubEquipmentService subEquipmentService;

    @ApiOperation("添加终端")
    @PostMapping("/subEquipment")
    public Result<SubEquipment> addSubEquipment(SubEquipment subEquipment, String operateUserId){
        try {
            Result<SubEquipment> result = subEquipmentService.addSubEquipment(subEquipment, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改终端")
    @PostMapping("/updateSubEquipment")
    public Result<SubEquipment> updateSubEquipment(SubEquipment subEquipment, String operateUserId){
        try {
            Result<SubEquipment> result = subEquipmentService.updateSubEquipment(subEquipment, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除终端")
    @PostMapping("/deleteSubEquipment")
    public Result<SubEquipment> deleteSubEquipment(String subEquipmentId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<SubEquipment> result = subEquipmentService.deleteSubEquipment(subEquipmentId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下终端列表")
    @GetMapping("/getSubEquipmentList")
    public Result<List<SubEquipment>> getSubEquipmentList(String keyword,String equipmentId, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return subEquipmentService.getSubEquipmentList(keyword,equipmentId,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

}
