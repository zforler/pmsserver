package com.wk.access.server.transfer;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class X509TrustAllManager implements TrustManager,X509TrustManager  {


	public boolean isServerTrusted(X509Certificate[] certs) {
		return true;
	}

	public boolean isClientTrusted(X509Certificate[] certs) {
		return true;
	}


	@Override
	public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
		x509Certificates[0].checkValidity();
		return;
	}

	@Override
	public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
		return;
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		//return null;
		return new X509Certificate[0];
	}

}
