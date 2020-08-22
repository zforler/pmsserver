package com.wk.platform.repo;

import com.wk.bean.MenuAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuAuthorityRepo extends JpaRepository<MenuAuthority,String> {
    int deleteAllByRoleId(String roleId);
}
