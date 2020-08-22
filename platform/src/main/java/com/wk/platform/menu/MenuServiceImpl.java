package com.wk.platform.menu;

import com.wk.bean.Menus;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
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
    @Autowired
    private CommonService commonService;

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
        List<Menus> res = menusList2Tree(menusList);
        return Result.success(res);
    }
    public List<Menus> menusList2Tree(List<Menus> menusList){
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

            if(parentId == null || parentId == 0){
                res.add(menus);
                continue;
            }else{
                if(map.containsKey(parentId)){
                    map.get(parentId).addChildren(menus);
                }else{
                    if(less.get(parentId) == null){
                        less.put(parentId, new ArrayList<>());
                    }
                    less.get(parentId).add(menus);
                }
            }

        }
        return res;
    }
    @Override
    public Result<List<Menus>> findUserMenus(String userId, String operateUserId) {
        String sql = "SELECT mau.authed,m.* FROM menu_authority mau LEFT JOIN menus m ON mau.menu_id=m.menu_id WHERE" +
                " mau.role_id=(SELECT role_id FROM user_info WHERE user_id=:userId)";
        Map<String,Object> param = new HashMap<>();
        param.put("userId", userId);
        List<Menus> menusList = commonService.listBySql(sql, param, Menus.class);
        List<Menus> res = menusList2Tree(menusList);
        return Result.success(res);
    }

    @Override
    public Result<List<Menus>> findUserConfigMenus(String roleId, String operateUserId) {
        String sql = "SELECT mau.authed,m.* FROM menu_authority mau LEFT JOIN menus m ON mau.menu_id=m.menu_id WHERE" +
                " mau.role_id=:roleId";
        Map<String,Object> param = new HashMap<>();
        param.put("roleId", roleId);
        List<Menus> menusListConfig = commonService.listBySql(sql, param, Menus.class);

        String sql2 = "SELECT mau.authed,m.* FROM menu_authority mau LEFT JOIN menus m ON mau.menu_id=m.menu_id WHERE" +
                " mau.role_id=(SELECT role_id FROM user_info WHERE user_id=:userId)";
        param = new HashMap<>();
        param.put("userId", operateUserId);
        List<Menus> menusList = commonService.listBySql(sql2, param, Menus.class);

        Menus menus = null;
        List<Menus> res = new ArrayList<>();
        Map<Integer,Menus> map = new HashMap<>();
        Map<Integer,List<Menus>> less = new HashMap<>();
        for (int i = 0, size = menusList.size(); i < size; i++) {
            menus = menusList.get(i);
            if(!menusListConfig.contains(menus)){
                menus.setAuthed(0);
            }
            int menuId = menus.getMenuId();
            map.put(menuId,menus);
            Integer parentId = menus.getParentId();

            if(less.containsKey(menuId)){
                menus.addChildren(less.get(menuId));
            }

            if(parentId == null || parentId == 0){
                res.add(menus);
                continue;
            }else{
                if(map.containsKey(parentId)){
                    map.get(parentId).addChildren(menus);
                }else{
                    if(less.get(parentId) == null){
                        less.put(parentId, new ArrayList<>());
                    }
                    less.get(parentId).add(menus);
                }
            }

        }

        return Result.success(res);
    }
}
