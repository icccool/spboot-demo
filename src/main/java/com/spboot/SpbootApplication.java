package com.spboot;

import com.spboot.config.Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启动程序入口
@SpringBootApplication
@MapperScan(value = "com.spboot.mapper")
public class SpbootApplication implements InitializingBean {

    @Autowired
    private Config config;

	public static void main(String[] args) {
		SpringApplication.run(SpbootApplication.class, args);
	}

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=========================");
        System.out.println("config.baseUrl : " + config.getBaseUrl());
        System.out.println("config.javaHome : " + config.getJavaHome());
        System.out.println("=========================");
    }
}
