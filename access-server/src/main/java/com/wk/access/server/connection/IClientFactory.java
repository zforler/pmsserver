/**
 * 
 */
package com.wk.access.server.connection;

/**
 * @author jiansun
 *
 */
public interface IClientFactory {
	/**
	 * 
	 * @param clientId
	 * @return
	 */
	Client createClient(String clientId);
}
