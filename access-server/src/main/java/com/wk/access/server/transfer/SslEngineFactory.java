package com.wk.access.server.transfer;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;

public class SslEngineFactory implements ISslEngineFactory {
	protected SSLEngine sslEngine;
	@Override
	public SSLEngine getSSLEngine() {
		if(sslEngine==null){
			TrustManager[] trustAllCerts = new TrustManager[1];
			TrustManager tm = new X509TrustAllManager();
			trustAllCerts[0] = tm;
			SSLContext sc = null;
			try {
				sc = SSLContext.getInstance("TLS");
				sc.init(null, trustAllCerts, null);
				sslEngine = sc.createSSLEngine();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sslEngine;
	}

	@Override
	public SSLEngine getSSLClientEngine() {
		TrustManager[] trustAllCerts = new TrustManager[1];
		TrustManager tm = new X509TrustAllManager();
		trustAllCerts[0] = tm;
		SSLContext sc = null;
		SSLEngine sslClientEngine=null;
		try {
			sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, null);
			sslClientEngine = sc.createSSLEngine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sslClientEngine;
	}

}
