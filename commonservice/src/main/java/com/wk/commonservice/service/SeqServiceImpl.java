package com.wk.commonservice.service;

import com.wk.bean.SysSeq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeqServiceImpl implements SeqService {
	protected static Logger logger = LoggerFactory.getLogger(SeqServiceImpl.class);
	@Autowired
	private SysSeqRepo sysSeqRepo;
	@Autowired
	private CommonService commonService;

	@Transactional
	@Override
	public String getNextBusinessId(String bizType, String customerId, int len) {
		String seqKey=String.format("%s:%s",bizType,customerId);
		SysSeq seq = sysSeqRepo.findFirstBySeqKey(seqKey);
		int index=1;
		if (seq == null){
			seq = new SysSeq();
			seq.setSeqKey(seqKey);
			seq.setNextIndex(index+1);
		}else {
			if(seq.getNextIndex() != null){
				index = seq.getNextIndex();
			}
			seq.setNextIndex(index+1);
		}
		String businessId=String.format("%s%0"+len+"d",customerId,index);
		sysSeqRepo.save(seq);
		return businessId;
	}

	@Override
	public SysSeq findOne(String seqKey) {
		return sysSeqRepo.findFirstBySeqKey(seqKey);
	}
	@Transactional
	@Override
	public SysSeq save(SysSeq sysSeq) {
		return sysSeqRepo.saveAndFlush(sysSeq);
	}
}
