package com.wx.commonservice.service;

import com.hcharger.platform.core.domain.SysSeq;
import com.hcharger.platform.core.repository.SysSeqRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SeqServiceImpl implements SeqService {
	protected static Logger logger = LoggerFactory.getLogger(SeqServiceImpl.class);
	@Autowired
	private SysSeqRepo sysSeqRepo;
	@Autowired
	private CommonService commonService;

	@Transactional
	@Override
	public String getNextBusinessId(String bizType, String operatorId, int len) {
		String seqKey=String.format("%s:%s",bizType,operatorId);
		updateSeq(bizType,operatorId,len,seqKey);
		SysSeq seq = sysSeqRepo.findFirstBySeqKey(seqKey);
		int index=1;
		if (seq == null){
			seq = new SysSeq();
			seq.setSeqKey(seqKey);
			index = getMaxSeq(bizType,operatorId,len);
			seq.setNextIndex(index+1);
		}else {
			if(seq.getNextIndex() != null){
				index = seq.getNextIndex();
			}
			seq.setNextIndex(index+1);
		}
		String businessId=String.format("%s%0"+len+"d",operatorId,index);
		sysSeqRepo.save(seq);
		return businessId;
	}

	@Override
	public SysSeq findOne(String seqKey) {
		return sysSeqRepo.findOne(seqKey);
	}
	@Transactional
	@Override
	public SysSeq save(SysSeq sysSeq) {
		return sysSeqRepo.saveAndFlush(sysSeq);
	}

	@Transactional
	public void updateSeq(String bizType, String id, int len,String seqKey){
		try {
			String sql = null;
			String tempId = id;
			if("CARD".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(card_id,5,8)+1),1) FROM card WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if("CHARGER".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(charger_id,7,8)+1),1) FROM charger WHERE station_id=:id) WHERE seq_key=:seqKey";
			}else if("ENTERPRISE".equals(bizType)){
				tempId = id.substring(0,4);
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(enterprise_id,6,7)+1),1) FROM enterprise WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if("LIST".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(list_id,7,8)+1),1) FROM list_info WHERE station_id=:id) WHERE seq_key=:seqKey";
			}else if("DISPATCHPOLICY".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(policy_id,7,12)+1),1) FROM policy_dispatch WHERE station_id=:id) WHERE seq_key=:seqKey";
			}else if("STARTPOLICY".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(policy_id,7,12)+1),1) FROM policy_startup WHERE station_id=:id) WHERE seq_key=:seqKey";
			}else if("RATE".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(rate_id,5,8)+1),1) FROM rate WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if("STATION".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(station_id,5,6)+1),1) FROM station WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if("USER".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(user_id,5,12)+1),1) FROM user_info WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if("ACCOUNT".equals(bizType)){
				tempId = id + "%";
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(account_id,5,12)+1),1) FROM account WHERE enterprise_id LIKE :id) WHERE seq_key=:seqKey";
			}else if("VEHICLEID".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(vehicle_id,5,8)+1),1) FROM vehicle WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if("role".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(role_id,5,8)+1),1) FROM sys_role WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if("ESUBUNIT".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(subunit_id,5,8)+1),1) FROM enterprise_subunit WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if("PAYSETTLEMENTCONFIG".equals(bizType)){
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(id,5,7)+1),1) FROM pay_settlement_config WHERE operator_id=:id) WHERE seq_key=:seqKey";
			}else if(bizType.equals(id) && len == 2){
				tempId = id + "%";
				sql = "UPDATE sys_seq SET next_index=(SELECT IFNULL(MAX(SUBSTRING(operator_id,3,4)+1),1) FROM operator_info WHERE operator_id LIKE :id) WHERE seq_key=:seqKey";
			}
			Map<String,Object> param = new HashMap<>();
			param.put("id", tempId);
			param.put("seqKey", seqKey);
			commonService.executeSql(sql, param);
		}catch (Exception e){
			logger.info(e.toString());
		}
	}

	public int getMaxSeq(String bizType, String id, int len){
		try {
			String sql = null;
			String tempId = id;
			if("CARD".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(card_id,5,8)+1),1) seq FROM card WHERE operator_id=:id";
			}else if("CHARGER".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(charger_id,7,8)+1),1) seq FROM charger WHERE station_id=:id";
			}else if("ENTERPRISE".equals(bizType)){
				tempId = id.substring(0,4);
				sql = "SELECT IFNULL(MAX(SUBSTRING(enterprise_id,6,7)+1),1) seq FROM enterprise WHERE operator_id=:id";
			}else if("LIST".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(list_id,7,8)+1),1) seq FROM list_info WHERE station_id=:id";
			}else if("DISPATCHPOLICY".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(policy_id,7,12)+1),1) seq FROM policy_dispatch WHERE station_id=:id";
			}else if("STARTPOLICY".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(policy_id,7,12)+1),1) seq FROM policy_startup WHERE station_id=:id";
			}else if("RATE".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(rate_id,5,8)+1),1) seq FROM rate WHERE operator_id=:id";
			}else if("STATION".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(station_id,5,6)+1),1) seq FROM station WHERE operator_id=:id";
			}else if("USER".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(user_id,5,12)+1),1) seq FROM user_info WHERE operator_id=:id";
			}else if("ACCOUNT".equals(bizType)){
				tempId = id + "%";
				sql = "SELECT IFNULL(MAX(SUBSTRING(account_id,5,12)+1),1) seq FROM account WHERE enterprise_id LIKE :id";
			}else if("VEHICLEID".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(vehicle_id,5,8)+1),1) seq FROM vehicle WHERE operator_id=:id";
            }else if("role".equals(bizType)){
                sql = "SELECT IFNULL(MAX(SUBSTRING(role_id,5,8)+1),1) FROM sys_role WHERE operator_id=:id";
			}else if("ESUBUNIT".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(subunit_id,5,8)+1),1) FROM enterprise_subunit WHERE operator_id=:id";
			}else if("PAYSETTLEMENTCONFIG".equals(bizType)){
				sql = "SELECT IFNULL(MAX(SUBSTRING(id,5,7)+1),1) FROM pay_settlement_config WHERE operator_id=:id";
			}else if(bizType.equals(id) && len == 2){
				tempId = id + "%";
				sql = "SELECT IFNULL(MAX(SUBSTRING(operator_id,3,4)+1),1) seq FROM operator_info WHERE operator_id LIKE :id";
			}
			Map<String,Object> param = new HashMap<>();
			param.put("id", tempId);
			Map<String,Object> res = commonService.nativeQuery4OneMap(sql,param);
			if(res != null){
				return (int)Optional.ofNullable((Double)res.get("seq")).orElse(0.0).doubleValue();
			}else {
				return 1;
			}
		}catch (Exception e){
			logger.info(e.toString());
		}
		return 1;
	}
}
