package com.wk.platform.role;

import com.wk.bean.MenuAuthority;
import com.wk.bean.Role;
import com.wk.common.constant.Const;
import com.wk.common.util.TimeUtil;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;
import com.wk.commonservice.service.CommonService;
import com.wk.commonservice.service.SeqService;
import com.wk.platform.repo.MenuAuthorityRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private SeqService seqService;
    @Autowired
    private MenuAuthorityRepo menuAuthorityRepo;
    @Autowired
    private CommonService commonService;
    @Transactional
    @Override
    public Result<Role> addRole(Role role, String auth, String operateUserId) {

        String cusotmerId = role.getCustomerId();
        String roleId = seqService.getNextBusinessId(Const.BZ_ROLE, cusotmerId, 4);
        role.setRoleId(roleId);
        int currentInSecond = TimeUtil.getCurrentInSecond();
        role.setCreateTime(currentInSecond);
        role.setUpdateTime(currentInSecond);
        Role newRole = roleRepo.saveAndFlush(role);

        saveAuth(auth,roleId);

        return Result.success(newRole);
    }
    @Transactional
    public void saveAuth(String auth,String roleId){
        String[] authArr = auth.split(",");
        List<MenuAuthority> menuAuthorities = new ArrayList<>(authArr.length);
        for (int i = 0,len=authArr.length; i < len; i++) {
            MenuAuthority menuAuthority = new MenuAuthority();
            menuAuthorities.add(menuAuthority);
            menuAuthority.setMenuId(Integer.valueOf(authArr[i]));
            menuAuthority.setRoleId(roleId);
            menuAuthority.setAuthed(1);
        }
        menuAuthorityRepo.saveAll(menuAuthorities);
    }
    @Transactional
    @Override
    public Result<Role> updateRole(Role role, String auth, String operateUserId) {
        String roleId = role.getRoleId();
        int currentInSecond = TimeUtil.getCurrentInSecond();
        role.setUpdateTime(currentInSecond);
        Role newRole = roleRepo.saveAndFlush(role);

        menuAuthorityRepo.deleteAllByRoleId(roleId);
        saveAuth(auth,roleId);

        return Result.success(newRole);
    }
    @Transactional
    @Override
    public Result deleteRole(String roleId, String operateUserId) {
        roleRepo.deleteAllByRoleId(roleId);
        menuAuthorityRepo.deleteAllByRoleId(roleId);
        return Result.success();
    }

    @Override
    public Result<List<Role>> getRoleList(String customerId, int level, String keyword, String operateUserId) {
        String sql = "select * from role WHERE customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (role_id LIKE :keyword OR role_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }
        List<Role> roles = commonService.listBySql(sql, param, Role.class);
        return Result.success(roles);
    }

    @Override
    public Result<PageList<Role>> getRolePageList(String keyword, int page, int size, String customerId, int level, String operateUserId) {

        String sql = "select * from role WHERE customer_id=:customerId";
        Map<String,Object> param = new HashMap<>();
        param.put("customerId",customerId);
        if(StringUtils.isNotBlank(keyword)){
            sql += " AND (role_id LIKE :keyword OR role_name LIKE :keyword)";
            param.put("keyword","%"+keyword+"%");
        }

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "roleId");
        Page<Role> list = commonService.pageBySql(sql,param,pageable,Role.class);

        return Result.success(new PageList<Role>(list.getContent(),list.getTotalElements(),page,size));
    }
}
