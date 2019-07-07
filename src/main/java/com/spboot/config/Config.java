package com.spboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Value("${pos.isOnline}")
	private String isOnline;

    @Value("${pos.baseUrl}")
    private String baseUrl;


	public String isOnline() {
		return isOnline;
	}

	public void setOnline(String isOnline) {
		this.isOnline = isOnline;
	}

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
