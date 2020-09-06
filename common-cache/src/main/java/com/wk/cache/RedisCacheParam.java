package com.wk.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheParam {
	@Value("${redis.cache.handle-max-count:50}")
	public int handleMaxCount ;
	@Value("${redis.cache.fault-max-count:10}")
	public int faultMaxCount ;
	@Value("${redis.cache.gunstatus-max-count:200}")
	public int gunstatusMaxCount ;
	@Value("${redis.cache.count-duration:30}")
	public int countTuration;
	@Value("${redis.cache.blacklist.handle-delay:3600}")
	public int blackListHandleDelay;
	@Value("${redis.cache.blacklist.message-delay:300}")
	public int blackListMessageDelay;
	//改为毫秒
	@Value("${redis.cache.lock-expire:30000}")
	public int lockExpire;

	public int getHandleMaxCount() {
		return handleMaxCount;
	}

	public void setHandleMaxCount(int handleMaxCount) {
		this.handleMaxCount = handleMaxCount;
	}

	public int getFaultMaxCount() {
		return faultMaxCount;
	}

	public void setFaultMaxCount(int faultMaxCount) {
		this.faultMaxCount = faultMaxCount;
	}

	public int getGunstatusMaxCount() {
		return gunstatusMaxCount;
	}

	public void setGunstatusMaxCount(int gunstatusMaxCount) {
		this.gunstatusMaxCount = gunstatusMaxCount;
	}

	public int getCountTuration() {
		return countTuration;
	}

	public void setCountTuration(int countTuration) {
		this.countTuration = countTuration;
	}

	public int getBlackListHandleDelay() {
		return blackListHandleDelay;
	}

	public void setBlackListHandleDelay(int blackListHandleDelay) {
		this.blackListHandleDelay = blackListHandleDelay;
	}

	public int getBlackListMessageDelay() {
		return blackListMessageDelay;
	}

	public void setBlackListMessageDelay(int blackListMessageDelay) {
		this.blackListMessageDelay = blackListMessageDelay;
	}

	public int getLockExpire() {
		return lockExpire;
	}

	public void setLockExpire(int lockExpire) {
		this.lockExpire = lockExpire;
	}
}
