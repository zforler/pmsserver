package com.wk.access.config;

import org.springframework.stereotype.Component;

@Component
public class ServerHost {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
