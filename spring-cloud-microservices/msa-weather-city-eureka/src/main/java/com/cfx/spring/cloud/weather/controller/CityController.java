package com.cfx.spring.cloud.weather.controller;

import com.cfx.spring.cloud.weather.service.CityDataService;
import com.cfx.spring.cloud.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: cfx
 * @Description:
 * @Date: Created in 2018/4/7 1:37
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;
    @GetMapping
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }

}
