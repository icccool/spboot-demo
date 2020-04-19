package com.spboot;

import com.spboot.config.TransConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

//启动程序入口
@SpringBootApplication
@MapperScan(value = "com.spboot.mapper")
public class SpbootApplication implements InitializingBean {

    @Value("${database.passwd}")
    private String passwd;

    @Autowired
    private TransConfig transConfig;

    @Autowired
    private RedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpbootApplication.class, args);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("==========================================================");
        System.out.println("测试使用jasypt配置脱敏密码:" + passwd);
        System.out.println("读取yml Map配置 = :" + transConfig.getMaps());
        redisTemplate.opsForValue().set("db-type", "redis测试");
        System.out.println(redisTemplate.opsForValue().get("db-type")); // 结果： redis
        System.out.println("==========================================================");
    }
}
