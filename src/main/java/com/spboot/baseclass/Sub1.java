package com.spboot.baseclass;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author WANG JI BO
 * @Date 2020/3/24 3:04 下午
 * @Description
 **/
@Component
@ConfigurationProperties(
        prefix = "sub1"
)
public class Sub1 extends BaseExt2 {

    @Value("${sub1.nameServer}")
    private String nameServer1;

    public String getNameServer() {
        return nameServer1 + "(子类重写了getNameServer())";
    }

}
