package com.cfx.spring.cloud.weather.service;

import com.cfx.spring.cloud.weather.vo.WeatherResponse;

/**
 * @Author: cfx
 * @Description: 天气数据接口
 * @Date: Created in 2018/4/5 10:38
 */
public interface WeatherDataService {
    /**
     * 根据城市Id查询天气
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

}
