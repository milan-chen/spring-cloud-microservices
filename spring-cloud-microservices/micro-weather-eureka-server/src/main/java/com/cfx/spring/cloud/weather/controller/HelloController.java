package com.cfx.spring.cloud.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cfx
 * @Description:
 * @Date: Created in 2018/4/5 9:30
 */
@RestController
public class HelloController {

    //@RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
