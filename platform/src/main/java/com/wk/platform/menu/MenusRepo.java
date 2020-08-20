package com.wk.platform.menu;

import com.wk.bean.Menus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenusRepo extends JpaRepository<Menus,Integer> {
    List<Menus> findAllByNameLike(String keyword);
}
