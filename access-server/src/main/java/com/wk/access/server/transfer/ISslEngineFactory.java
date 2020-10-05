package com.wk.access.server.transfer;

import javax.net.ssl.SSLEngine;

public interface ISslEngineFactory {
	SSLEngine getSSLEngine();
	SSLEngine getSSLClientEngine();
}
