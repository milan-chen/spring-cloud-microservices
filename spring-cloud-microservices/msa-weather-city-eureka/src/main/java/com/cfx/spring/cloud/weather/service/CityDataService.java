package com.cfx.spring.cloud.weather.service;

import com.cfx.spring.cloud.weather.vo.City;

import java.util.List;

/**
 * @Author: cfx
 * @Description: 城市数据服务接口
 * @Date: Created in 2018/4/5 22:32
 */
public interface CityDataService {
    /**
     * 获取City列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
