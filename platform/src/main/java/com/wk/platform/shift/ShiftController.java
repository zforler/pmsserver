package com.wk.platform.shift;

import com.wk.bean.Shift;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import com.wk.platform.shift.ShiftController;
import com.wk.platform.shift.ShiftService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShiftController {
    private final Logger logger = LoggerFactory.getLogger(ShiftController.class);
    @Autowired
    private ShiftService shiftService;

    @ApiOperation("添加班次")
    @PostMapping("/shift")
    public Result<Shift> addShift(Shift shift, String operateUserId){
        try {
            Result<Shift> result = shiftService.addShift(shift, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改班次")
    @PostMapping("/updateShift")
    public Result<Shift> updateShift(Shift shift, String operateUserId){
        try {
            Result<Shift> result = shiftService.updateShift(shift, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除班次")
    @PostMapping("/deleteShift")
    public Result<Shift> deleteShift(String shiftId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Shift> result = shiftService.deleteShift(shiftId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下班次列表")
    @GetMapping("/getShiftList")
    public Result<List<Shift>> getShiftList(String keyword, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return shiftService.getShiftList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation("获取企业下历史班次列表")
    @GetMapping("/getHisShiftList")
    public Result<List<Shift>> getHisShiftList(String shiftId, String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return shiftService.getHisShiftList(shiftId,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
