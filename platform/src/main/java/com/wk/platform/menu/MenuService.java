package com.wk.platform.menu;

import com.wk.bean.Menus;
import com.wk.common.vo.Result;

import java.util.List;

public interface MenuService {
    Result<Menus> addMenus(Menus menus,String operateUserId);
    Result<List<Menus>> findAllMenus(String keyword, String operateUserId);
}
