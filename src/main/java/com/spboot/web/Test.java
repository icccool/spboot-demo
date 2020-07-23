package com.spboot.web;

import java.math.BigDecimal;

/**
 * @Author WANG JI BO
 * @Date 2020/5/16 5:08 下午
 * @Description
 **/
public class Test {
    public static void main(String[] args) {
        //使用工具类
        BigDecimal bigDecimal = new BigDecimal(2.333333333333);
        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.doubleValue());
    }
}
