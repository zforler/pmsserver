package com.wk.platform.datadic;

import com.wk.bean.SysDic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysDicRepo extends JpaRepository<SysDic,String> {
    int deleteAllByCode(String code);
}
