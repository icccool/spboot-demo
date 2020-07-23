package com.spboot.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author WANG JI BO
 * @Date 2020/4/17 9:55 下午
 * @Description
 **/
@Component
//@ConfigurationProperties(prefix = "cloud.trans-up-conf")
@ConfigurationProperties(prefix = "cloud")
public class TransConfig {

    private Map<String, JSONObject> transUpConf;

    public Map<String, JSONObject> getTransUpConf() {
        return transUpConf;
    }

    public void setTransUpConf(Map<String, JSONObject> transUpConf) {
        this.transUpConf = transUpConf;
    }
}
