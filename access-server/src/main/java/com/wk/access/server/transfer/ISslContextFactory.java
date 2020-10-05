/**
 * 
 */
package com.wk.access.server.transfer;

import io.netty.handler.ssl.SslContext;

/**
 * @author jiansun
 *
 */
public interface ISslContextFactory {
	/**
	 * 
	 * @return
	 */
	SslContext getSslContext();
}
