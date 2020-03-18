package com.spboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private int sum = 0;

    @RequestMapping("/test")
    public String index() {
        sum = sum + 1;
        System.out.println(String.format("tid = %s,sum=%s", Thread.currentThread().getId(), sum));
        return "Hello, Test";
    }

}
