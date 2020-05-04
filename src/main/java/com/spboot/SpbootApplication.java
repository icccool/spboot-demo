package com.spboot;

import com.spboot.config.TransConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//启动程序入口
@SpringBootApplication
public class SpbootApplication implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(SpbootApplication.class);

    @Value("${database.passwd}")
    private String passwd;

//    @Autowired
//    private RedisTemplate redisTemplate;




    public static void main(String[] args) {
        SpringApplication.run(SpbootApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("==========================================================");
        logger.info("测试使用jasypt配置脱敏密码:" + passwd);
//        logger.info("读取yml Map配置 = :" + transConfig.getMaps());
//        redisTemplate.opsForValue().set("db-type", "redis测试");
//        logger.info(redisTemplate.opsForValue().get("db-type").toString()); // 结果： redis
    }
}
