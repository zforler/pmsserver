package com.wk.commonservice.service;

import com.wk.bean.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysLogRepo extends JpaRepository<SysLog,Long> {
}
