package com.wk.platform.menu;

import com.wk.bean.Menus;
import com.wk.common.cache.LocalMemCache;
import com.wk.common.vo.Result;
import com.wk.config.interceptor.LogInterceptor;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {
    private final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;

    @ApiOperation("添加菜单")
    @PostMapping("/menus")
    public Result<Menus> addMenus(Menus menus,String operateUserId){
        try {
            Result<Menus> menusResult = menuService.addMenus(menus, operateUserId);
            return menusResult;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取所有菜单列表")
    @GetMapping("/menus")
    public Result<List<Menus>> findAllMenus(String keyword,String operateUserId){
        try {
            Result<List<Menus>> menusResult = menuService.findAllMenus(keyword, operateUserId);
            return menusResult;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }

    @ApiOperation("获取用户菜单列表")
    @GetMapping("/menus/{userId}")
    public Result<List<Menus>> findUserMenus(@PathVariable String userId, String operateUserId){
        try {
            Result<List<Menus>> menusResult = menuService.findUserMenus(userId, operateUserId);
            return menusResult;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }


    @ApiOperation("获取用户配置菜单列表")
    @GetMapping("/menus/config")
    public Result<List<Menus>> findUserConfigMenus(String roleId, String token){
        try {
            String operateUserId = LocalMemCache.getUserIdByToken(token);
            Result<List<Menus>> menusResult = menuService.findUserConfigMenus(roleId, operateUserId);
            return menusResult;
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return Result.error(e.getMessage());
        }
    }
}
