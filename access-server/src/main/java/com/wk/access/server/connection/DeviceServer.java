package com.wk.access.server.connection;


import org.springframework.beans.factory.InitializingBean;

public class DeviceServer implements InitializingBean {

	protected Service deviceNoSslService;
	protected Service deviceSslService;

	


	public void setDeviceNoSslService(Service deviceNoSslService) {
		this.deviceNoSslService = deviceNoSslService;
	}

	public void setDeviceSslService(Service deviceSslService) {
		this.deviceSslService = deviceSslService;
	}


	/**
	 * 
	 */
	public void initialize(){
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.initialize();
		
		// 启动接入监听服务
//		this.deviceSslService.start();
		// 启动接入监听服务
		this.deviceNoSslService.start();

	}
}
