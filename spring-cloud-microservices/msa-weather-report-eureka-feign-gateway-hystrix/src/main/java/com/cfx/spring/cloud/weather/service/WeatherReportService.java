package com.cfx.spring.cloud.weather.service;

import com.cfx.spring.cloud.weather.vo.Weather;

/**
 * @Author: cfx
 * @Description: 天气预报服务
 * @Date: Created in 2018/4/6 13:41
 */
public interface WeatherReportService {

    /**
     * 根据城市Id查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
