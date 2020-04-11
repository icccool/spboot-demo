package com.spboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启动程序入口
@SpringBootApplication
@MapperScan(value = "com.spboot.mapper")
public class SpbootApplication implements InitializingBean {

    @Value("${database.passwd}")
    private String passwd;

    public static void main(String[] args) {
        SpringApplication.run(SpbootApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=========================" + passwd);
    }
}
