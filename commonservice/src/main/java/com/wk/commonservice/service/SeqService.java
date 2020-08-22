package com.wk.commonservice.service;


import com.wk.bean.SysSeq;

public interface SeqService {

    String getNextBusinessId(String bizType, String id, int len);

    SysSeq findOne(String seqKey);

    SysSeq save(SysSeq sysSeq);
}
