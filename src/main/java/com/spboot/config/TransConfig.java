package com.spboot.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author WANG JI BO
 * @Date 2020/4/17 9:55 下午
 * @Description
 **/
//@Component
//@ConfigurationProperties(prefix = "trans-up-conf")
public class TransConfig {

    private Map<String, JSONObject> maps;

    public Map<String, JSONObject> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, JSONObject> maps) {
        this.maps = maps;
    }
}
