package com.wk.platform.staff;

import com.wk.bean.Card;
import com.wk.bean.Staff;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.platform.staff.StaffService;
import com.wk.platform.role.RoleController;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private StaffService staffService;

    @ApiOperation("添加员工")
    @PostMapping("/staff")
    public Result<Staff> addStaff(Staff staff, String operateUserId){
        try {
            Result<Staff> result = staffService.addStaff(staff, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改员工")
    @PostMapping("/updateStaff")
    public Result<Staff> updateStaff(Staff staff, String operateUserId){
        try {
            Result<Staff> result = staffService.updateStaff(staff, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除员工")
    @PostMapping("/deleteStaff")
    public Result<Staff> deleteStaff(String staffId,String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Staff> result = staffService.deleteStaff(staffId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下员工列表")
    @GetMapping("/getStaffList")
    public Result<List<Staff>> getStaffList(String keyword,String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return staffService.getStaffList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取员工分页列表")
    @GetMapping("/getStaffPageList")
    public Result<PageList<Staff>> getStaffPageList(String keyword, int page, int size, String customerId,
                                                    @RequestParam(required = false,defaultValue = "-1") int status,
                                                    @RequestParam(required = false,defaultValue = "-1")int sex,
                                                    @RequestParam(required = false,defaultValue = "-1")int staffType,
                                                    String departmentId,
                                                    @RequestParam(required = false,defaultValue = "-1")int departmentType,
                                                    String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return staffService.getStaffPageList(keyword, page, size,customerId, status, sex,staffType,departmentId,
                    departmentType, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("获取未分配班组员工列表")
    @GetMapping("/getNoDepartStaffList")
    public Result<List<Staff>> getStaffPageList(String keyword, String customerId,
                                                    @RequestParam(required = false,defaultValue = "-1")int sex,
                                                    @RequestParam(required = false,defaultValue = "-1")int staffType,
                                                    String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return staffService.getNoDepartStaffList(keyword, sex,staffType,customerId,operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("批量分配班组")
    @PostMapping("/configDeparts")
    public Result configDeparts(String staffIds, String departmentId,
                                                String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return staffService.configDeparts(staffIds, departmentId,operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("解绑分组")
    @PostMapping("/unbindDepart")
    public Result unbindDepart(String staffId,  String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return staffService.unbindDepart(staffId,operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取班组下员工列表")
    @GetMapping("/getDepartStaffPageList")
    public Result<PageList<Staff>> getDepartStaffPageList(String keyword, int page, int size, String customerId, String departmentId,
                                                      @RequestParam(required = false,defaultValue = "-1")int sex,
                                                      @RequestParam(required = false,defaultValue = "-1")int staffType,
                                                      String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return staffService.getDepartStaffPageList(keyword,page,size,customerId, sex,staffType, departmentId,operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("获取未绑定电卡员工列表")
    @GetMapping("/getUnbindCardStaffList")
    public Result<List<Staff>> getUnbindCardStaffList(String keyword,String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return staffService.getUnbindCardStaffList(keyword,customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("绑定电卡")
    @PostMapping("/bindCards")
    public Result bindCards(String staffId,String cardIds,String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result result = staffService.bindCards(cardIds,staffId,customerId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("解绑电卡")
    @PostMapping("/unbindCards")
    public Result unbindCards(String staffId,String cardIds,String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result result = staffService.unbindCards(cardIds,staffId,customerId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("根据员工编号获取员工信息")
    @GetMapping("/getStaffByStaffNo")
    public Result<Staff> getStaffByStaffNo(String staffNo,String customerId, String operateUserId){
        try {
            Result<Staff> result = staffService.getStaffByStaffNo(staffNo, customerId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
