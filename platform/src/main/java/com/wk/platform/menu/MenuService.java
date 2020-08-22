package com.wk.platform.menu;

import com.wk.bean.Menus;
import com.wk.common.vo.Result;

import java.util.List;

public interface MenuService {
    Result<Menus> addMenus(Menus menus,String operateUserId);

    Result<List<Menus>> findAllMenus(String keyword, String operateUserId);

    Result<List<Menus>> findUserMenus(String userId,String operateUserId);

    Result<List<Menus>> findUserConfigMenus(String userId,String operateUserId);
}
