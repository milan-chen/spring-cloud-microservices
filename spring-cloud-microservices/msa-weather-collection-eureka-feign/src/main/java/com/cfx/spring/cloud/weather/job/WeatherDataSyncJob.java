package com.cfx.spring.cloud.weather.job;

import com.cfx.spring.cloud.weather.service.CityClient;
import com.cfx.spring.cloud.weather.service.WeatherDataCollectionService;
import com.cfx.spring.cloud.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @Author: cfx
 * @Description: 天气数据同步Job
 * @Date: Created in 2018/4/5 19:51
 */
public class WeatherDataSyncJob extends QuartzJobBean{

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	
    @Autowired
	private CityClient cityClient;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("天气数据同步Job,Start!");
		// 获取城市ID列表
		List<City> cityList = null;
		
		try {
			
			// 由城市数据API微服务提供数据
			cityList = cityClient.listCity();
		} catch (Exception e) {
			logger.error("Exception!", e);
		}
		
		// 遍历城市ID获取天气
		for (City city : cityList) {
			String cityId = city.getCityId();
			logger.info("天气数据同步Job,cityId:" + cityId);
			
			weatherDataCollectionService.syncDataByCityId(cityId);
		}

		logger.info("天气数据同步Job,End!");
	}
}
