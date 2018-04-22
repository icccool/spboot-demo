package com.spboot.spboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${isOnline}")
	private String isOnline;

	public String isOnline() {
		return isOnline;
	}

	public void setOnline(String isOnline) {
		this.isOnline = isOnline;
	}
	
	
}
