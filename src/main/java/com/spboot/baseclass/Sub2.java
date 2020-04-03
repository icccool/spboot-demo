package com.spboot.baseclass;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author WANG JI BO
 * @Date 2020/3/24 3:04 下午
 * @Description
 **/
@Component
@ConfigurationProperties(
        prefix = "sub2"
)
public class Sub2 extends BaseExt2 {
}
