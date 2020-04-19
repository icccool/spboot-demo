package com.spboot.config;

import org.springframework.beans.factory.annotation.Value;

//@Component
public class MyConfig {

    @Value("${pos.isOnline}")
	private String isOnline;

    @Value("${pos.baseUrl}")
    private String baseUrl;

    @Value("${pos.javaHome}")
    private String javaHome;


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

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }
}
