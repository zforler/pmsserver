package com.wk.platform.role;

import com.wk.bean.Menus;
import com.wk.bean.Role;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
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
public class RoleController {
    private final Logger logger = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;


    @ApiOperation("添加角色")
    @PostMapping("/role")
    public Result<Role> addRole(Role role,String auth, String operateUserId){
        try {
            Result<Role> result = roleService.addRole(role,auth, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("修改角色")
    @PostMapping("/updaterole")
    public Result<Role> updateRole(Role role,String auth, String operateUserId){
        try {
            Result<Role> result = roleService.updateRole(role,auth, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
    @ApiOperation("删除角色")
    @PostMapping("/deleteRole")
    public Result<Role> deleteRole(String roleId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<Role> result = roleService.deleteRole(roleId, operateUserId);
            return result;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取企业下角色列表")
    @GetMapping("/getRoleList")
    public Result<List<Role>> getRoleList(String keyword, String customerId,
                                          @RequestParam(required = false,defaultValue = "-1") int level,
                                          String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return roleService.getRoleList(customerId,level,keyword,  operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取角色分页列表")
    @GetMapping("/getRolePageList")
    public Result<PageList<Role>> getRolePageList(String keyword, int page, int size, String customerId,
                                                  @RequestParam(required = false,defaultValue = "-1") int level,
                                                  String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            return roleService.getRolePageList(keyword, page, size, customerId,level, operateUserId);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
