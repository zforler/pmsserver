package com.wk.platform.menu;

import com.wk.bean.Menus;
import com.wk.common.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenusRepo menusRepo;
    @Override
    public Result<Menus> addMenus(Menus menus, String operateUserId) {
        Menus newMenus = menusRepo.saveAndFlush(menus);
        return Result.success(newMenus);
    }

    @Override
    public Result<List<Menus>> findAllMenus(String keyword, String operateUserId) {
        List<Menus> menusList = null;
        if(StringUtils.isNotBlank(keyword)){
            menusList =menusRepo.findAllByNameLike(keyword);
        }else{
            menusList = menusRepo.findAll();
        }
        Menus menus = null;
        List<Menus> res = new ArrayList<>();
        Map<Integer,Menus> map = new HashMap<>();
        Map<Integer,List<Menus>> less = new HashMap<>();
        for (int i = 0, size = menusList.size(); i < size; i++) {
            menus = menusList.get(i);
            int menuId = menus.getMenuId();
            map.put(menuId,menus);
            Integer parentId = menus.getParentId();

            if(less.containsKey(menuId)){
                menus.addChildren(less.get(menuId));
            }

            if(parentId == null){
                res.add(menus);
                continue;
            }else{
                if(map.containsKey(parentId)){
                    map.get(parentId).addChildren(menus);
                }else{
                    less.get(parentId).add(menus);
                }
            }

        }
        return Result.success(res);
    }
}
