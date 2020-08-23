package com.wk.platform.datadic;

import com.wk.bean.SysDicItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysDicItemRepo extends JpaRepository<SysDicItem,Integer> {
    int deleteAllByCode(String code);
    int deleteAllById(int id);
}
