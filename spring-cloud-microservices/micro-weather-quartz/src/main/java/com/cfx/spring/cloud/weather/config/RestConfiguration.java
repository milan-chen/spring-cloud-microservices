package com.cfx.spring.cloud.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: cfx
 * @Description: 配置RestTemplate
 * @Date: Created in 2018/4/5 11:09
 */
@Configuration
public class RestConfiguration {
    //启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
    @Autowired
    private RestTemplateBuilder builder;
    @Bean
    public  RestTemplate restTemplate() {
        return builder.build();
    }
}
