package com.wk.platform.role;

import com.wk.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,String> {
    int deleteAllByRoleId(String roleId);
    Role findFirstByRoleId(String roleId);
}
