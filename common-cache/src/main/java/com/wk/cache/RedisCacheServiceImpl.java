package com.wk.cache;


import com.google.gson.Gson;
import com.wk.bean.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheServiceImpl implements RedisCacheService {
	private static final Logger logger = LoggerFactory.getLogger(RedisCacheServiceImpl.class);
	private static String LOCK_PREFIX = "lock";
	private static int BAOZE_EXPIRE=48*60*60;
	//private static long LOCK_EXPIRE = 120;
	@Autowired
	private RedisCacheParam redisCacheParam;
	@Autowired
	private RedisTemplate<String,String> redisTemplate;
	@Autowired
	private RedisTemplate<String,Long> longRedisTemplate;
	@Autowired
	private Gson gson;

	@Override
	public boolean delay(String key, long timeout){
		String lockKey = LOCK_PREFIX + key;
		String value=lockKey.hashCode()+"";
		//纳秒
		long start = System.nanoTime();

		try {
			String status = redisTemplate.execute(new RedisCallback<String>() {
				@Override
				public String doInRedis(RedisConnection connection) throws DataAccessException {
					JedisCluster jedis = (JedisCluster) connection.getNativeConnection();
					String status = jedis.set(lockKey, value, "nx", "px", timeout);
					return status;
				}
			});
      		if ("OK".equals(status)) {//抢到锁
				logger.info("delayLock[{}]", key);
        		return true;
      		}

		} catch (Exception e) {
			logger.error("delay:{}", e.getMessage(), e);
			//unlock(key);

		}
		return false;
	}
	@Override
	public RedisLock lock(String key,long timeout) {

		String lockKey = LOCK_PREFIX + key;
		long nanoWaitForLock = TimeUnit.MILLISECONDS.toNanos(timeout);
		//纳秒
		long start = System.nanoTime();
		String threadId= UUID.randomUUID().toString();
		try {
			//logger.info("current:{},start:{},wait:{}",System.nanoTime(),start,nanoWaitForLock);
			while ((System.nanoTime() - start) <= nanoWaitForLock) {
				//logger.info("begin try lock :"+lockKey);
				String status = redisTemplate.execute(new RedisCallback<String>() {
					@Override
					public String doInRedis(RedisConnection connection) throws DataAccessException {
						JedisCluster jedis = (JedisCluster) connection.getNativeConnection();
						String status = jedis.set(lockKey, threadId, "nx", "px", redisCacheParam.lockExpire);
						return status;
					}
				});
				if ("OK".equals(status)) {//抢到锁
					logger.info("addLock[{}]", lockKey);
					return RedisLock.locked(threadId,lockKey);
				}

				if((System.nanoTime() - start) > nanoWaitForLock){
					return RedisLock.failed();
				}
				TimeUnit.MILLISECONDS.sleep(200 + new Random().nextInt(100));//加随机时间防止活锁
				if(Thread.currentThread().isInterrupted()){
					break;
				}
			}
		} catch (Exception e) {
			logger.error("lock error:"+key+",{}", e.getMessage(), e);
			//unlock(key);

		}
		return RedisLock.failed();
	}
	@Override
	public void unlock(RedisLock lock) {
		try {
			String lockKey = lock.getKey();
			String value = redisTemplate.opsForValue().get(lockKey);
			if(lock.getId().equals(value)){
				redisTemplate.delete(lockKey);
			}

			logger.info("unlock ok :[{}].{}", lockKey, lock.id);
		} catch (Exception e) {
			logger.error("unlock error:"+lock.key+",{}" , e.getMessage(), e);
		}
	}

    @Override
    public boolean addUserInfo(String token, UserInfo userInfo) {
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		opsForValue.set(token,gson.toJson(userInfo),8,TimeUnit.HOURS);
        return true;
    }

    @Override
    public UserInfo getUserInfo(String token) {
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		String s = opsForValue.get(token);
		if(s != null){
			return gson.fromJson(s,UserInfo.class);
		}
		return null;
	}

    @Override
    public boolean deleteUserInfo(String token) {
        return false;
    }
}
