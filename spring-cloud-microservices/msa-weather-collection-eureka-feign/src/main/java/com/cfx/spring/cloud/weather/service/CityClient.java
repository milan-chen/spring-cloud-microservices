package com.cfx.spring.cloud.weather.service;

import com.cfx.spring.cloud.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author: cfx
 * @Description:
 * @Date: Created in 2018/4/8 0:24
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {
	
	@GetMapping("/cities")
	List<City> listCity() throws Exception;
}
