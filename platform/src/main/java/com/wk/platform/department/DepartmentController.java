package com.wk.platform.department;

import com.wk.bean.Department;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.platform.department.DepartmentService;
import com.wk.platform.role.RoleController;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("添加部门")
    @PostMapping("/department")
    public Result<Department> addDepartment(Department department, String operateUserId){
        try {
            Result<Department> result = departmentService.addDepartment(department, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改部门")
    @PostMapping("/updateDepartment")
    public Result<Department> updateDepartment(Department department, String operateUserId){
        try {
            Result<Department> result = departmentService.updateDepartment(department, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除部门")
    @PostMapping("/deleteDepartment")
    public Result<Department> deleteDepartment(int id, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Department> result = departmentService.deleteDepartment(id, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下部门列表")
    @GetMapping("/getDepartmentList")
    public Result<List<Department>> getDepartmentList(String customerId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return departmentService.getDepartmentList(customerId,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
