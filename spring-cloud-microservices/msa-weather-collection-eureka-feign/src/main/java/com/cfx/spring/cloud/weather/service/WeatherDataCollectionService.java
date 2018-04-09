package com.cfx.spring.cloud.weather.service;

/**
 * @Author: cfx
 * @Description: 数据采集服务
 * @Date: Created in 2018/4/7 0:24
 */
public interface WeatherDataCollectionService {
    /**
     * 根据城市Id同步数据
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
