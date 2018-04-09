package com.cfx.spring.cloud.weather.service;

import com.cfx.spring.cloud.weather.vo.City;
import com.cfx.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author: cfx
 * @Description: 数据客户端
 * @Date: Created in 2018/4/8 14:47
 */
@FeignClient(name = "msa-weather-eureka-client-zuul", fallback = DataClientFallback.class)
public interface DataClient {
    /**
     * 获取撑死列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
