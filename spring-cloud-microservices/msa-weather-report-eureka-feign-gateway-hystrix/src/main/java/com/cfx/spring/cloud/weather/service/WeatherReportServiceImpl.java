package com.cfx.spring.cloud.weather.service;

import com.cfx.spring.cloud.weather.vo.Forecast;
import com.cfx.spring.cloud.weather.vo.Weather;
import com.cfx.spring.cloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cfx
 * @Description:
 * @Date: Created in 2018/4/6 13:43
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        //由数据天气数据API微服务来提供
        WeatherResponse resp = dataClient.getDataByCityId(cityId);
        Weather data = null;
        if (null != resp) {
           data = resp.getData();
        }
        return data;
    }
}
