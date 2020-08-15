package com.wx.commonservice.service;


import com.hcharger.platform.core.domain.SysSeq;

public interface SeqService {

    String getNextBusinessId(String bizType, String operatorId, int len);

    SysSeq findOne(String seqKey);

    SysSeq save(SysSeq sysSeq);
}
