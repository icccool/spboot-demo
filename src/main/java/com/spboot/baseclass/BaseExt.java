package com.spboot.baseclass;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @Author WANG JI BO
 * @Date 2020/3/24 3:03 下午
 * @Description
 **/
@Component
@ConfigurationProperties(
        prefix = "base"
)
public abstract class BaseExt implements Base, InitializingBean {

    private String nameServer;

    public String getNameServer() {
        return nameServer;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

}
