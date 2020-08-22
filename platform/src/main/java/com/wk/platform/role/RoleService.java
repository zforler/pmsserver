package com.wk.platform.role;

import com.wk.bean.Role;
import com.wk.common.vo.PageList;
import com.wk.common.vo.Result;

import java.util.List;

public interface RoleService {
    Result<Role> addRole(Role role,String auth, String operateUserId);

    Result<Role> updateRole(Role role,String auth,String operateUserId);

    Result deleteRole(String roleId,String operateUserId);

    Result<List<Role>> getRoleList(String customerId,int level,String keyword,String operateUserId);

    Result<PageList<Role>> getRolePageList(String keyword, int page, int size, String customerId,
                                           int level,String operateUserId);
}
