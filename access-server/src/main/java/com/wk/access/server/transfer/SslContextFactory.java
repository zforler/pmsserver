/**
 * 
 */
package com.wk.access.server.transfer;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;

import javax.net.ssl.KeyManagerFactory;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/**
 * @author jiansun
 *
 */
public class SslContextFactory implements ISslContextFactory {
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
	public SslContext getSslContext() {
		if(context == null) {
			try {
				KeyStore ks = KeyStore.getInstance("JKS");
					ks.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(jksPath), password.toCharArray());
		        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		        kmf.init(ks, password.toCharArray());
	
		        context = SslContextBuilder.forServer(kmf).build();
			} catch (KeyStoreException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (CertificateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (UnrecoverableKeyException e) {
				e.printStackTrace();
			}
		}
		
		return context;
	}

}
