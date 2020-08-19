package com.wk.platform.menu;

import com.wk.bean.Menus;
import com.wk.common.vo.Result;

public interface MenuService {
    Result<Menus> addMenus(Menus menus,String operatorId);
}
