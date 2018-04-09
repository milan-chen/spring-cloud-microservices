package com.cfx.spring.cloud.weather.service;

import com.cfx.spring.cloud.weather.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: cfx
 * @Description: WeatherDataService的实现
 * @Date: Created in 2018/4/5 10:42
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.doGetWeather(uri);
    }

    /**
     * 重构代码
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri) {
        String key = uri;
        String strBody = null;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse resp = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        //先查缓存，如果缓存中有天气信息就在缓存中取
        if (stringRedisTemplate.hasKey(key)) {
            logger.info("Redis has data");
            strBody = ops.get(key);
        } else {
            logger.info("Redis don't has data");
            //如果缓存没有，抛出异常
            throw new RuntimeException("don't has data");

        }

        try {
            resp = mapper.readValue(strBody,WeatherResponse.class);
        } catch (IOException e) {
            logger.info("Error!!",e);
        }

        return resp;
    }

}
