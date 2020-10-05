/**
 * 
 */
package com.wk.access.server.transfer;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * @author jiansun
 *
 */
public class SslContextFactoryForClient implements ISslContextFactory {
	protected SslContext context;
	
	protected String jksPath;
	protected String password;

	/**
	 * @param jksPath the jksPath to set
	 */
	public void setJksPath(String jksPath) {
		this.jksPath = jksPath;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see com.hcharger.util.ISslContextFactory#getSslContext()
	 */
	public SslContext getSslContext()  {
		if(context == null) {
			try {
				KeyStore ks = KeyStore.getInstance("JKS");

				ks.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(jksPath), password.toCharArray());
		        
		        TrustManagerFactory tf =  TrustManagerFactory.getInstance("SunX509");
		        tf.init(ks);

				context = SslContextBuilder.forClient().trustManager(tf).build();
		        
			} catch (KeyStoreException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}  catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
			    e.printStackTrace();
			}
		}
		
		return context;
	}

}
