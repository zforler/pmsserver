package com.wk.platform.staff;

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
    public Result<Staff> deleteStaff(String staffId, String token){
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
}
