package com.spboot.baseclass;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author WANG JI BO
 * @Date 2020/3/24 3:03 下午
 * @Description
 **/
@ConfigurationProperties(
        prefix = "base"
)
public abstract class BaseExt implements Base, InitializingBean {

    private String nameServer;

    private String groupname;

    public String getNameServer() {
        return nameServer;
    }

    public void setNameServer(String nameServer) {
        this.nameServer = nameServer;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

}
