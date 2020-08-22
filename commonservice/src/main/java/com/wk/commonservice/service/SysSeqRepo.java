package com.wk.commonservice.service;

import com.wk.bean.SysSeq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysSeqRepo extends JpaRepository<SysSeq,String> {
    SysSeq findFirstBySeqKey(String key);
}
