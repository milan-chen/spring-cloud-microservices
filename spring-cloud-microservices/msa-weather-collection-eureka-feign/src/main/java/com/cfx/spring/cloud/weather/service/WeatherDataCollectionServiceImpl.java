package com.cfx.spring.cloud.weather.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Author: cfx
 * @Description: 数据采集服务实现
 * @Date: Created in 2018/4/7 0:26
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final long TIME_OUT = 1800L;//1800s

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 把天气数据放入缓存
     * 相当于更新缓存
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String key = uri;
        String strBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //调用服务接口来获取
        ResponseEntity<String> respString = restTemplate.getForEntity(uri,String.class);

        //将接口返回的Json字符串转换成对象
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }

        //数据写入缓存
        ops.set(uri, strBody, TIME_OUT, TimeUnit.SECONDS);
    }
}
