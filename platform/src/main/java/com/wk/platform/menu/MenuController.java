package com.wk.platform.menu;

import com.wk.bean.Menus;
import com.wk.common.vo.Result;
import com.wk.config.interceptor.LogInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
    private final Logger logger = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;

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
}
