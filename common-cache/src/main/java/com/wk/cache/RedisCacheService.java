package com.wk.cache;

import com.wk.bean.UserInfo;

import java.util.List;
import java.util.Map;

public interface RedisCacheService {
	boolean delay(String key, long timeout);
	//获取分布式锁
	RedisLock lock(String key, long timeout);
	//释放锁
	void unlock(RedisLock lock);


	boolean addUserInfo(String token , UserInfo userInfo);

	UserInfo getUserInfo(String token);

	boolean deleteUserInfo(String token);
}
