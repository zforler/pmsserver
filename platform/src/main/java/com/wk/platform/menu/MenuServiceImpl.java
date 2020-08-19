package com.wk.platform.menu;

import com.wk.bean.Menus;
import com.wk.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenusRepo menusRepo;
    @Override
    public Result<Menus> addMenus(Menus menus, String operatorId) {
        Menus newMenus = menusRepo.saveAndFlush(menus);
        return Result.success(newMenus);
    }
}
