/**
 * 
 */
package com.wk.access.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * handler连接池
 * configbean注入
 *
 */

public class HandlerExecutor extends ThreadPoolExecutor {
	public HandlerExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), new DiscardOldestPolicy());
	}
}
