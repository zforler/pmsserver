package com.wk.cache;

public class RedisLock {
	String id;
	String key;
	boolean locked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public RedisLock (){
		this.id=null;
		this.key=null;
		this.locked=false;

	}
	public static RedisLock locked(String id,String key) {
		RedisLock redisLock = new RedisLock();
		redisLock.setId(id);
		redisLock.setKey(key);
		redisLock.setLocked(true);
		return redisLock;
	}
	public static RedisLock failed() {
		RedisLock redisLock = new RedisLock();
		redisLock.setLocked(false);
		return redisLock;
	}
}
