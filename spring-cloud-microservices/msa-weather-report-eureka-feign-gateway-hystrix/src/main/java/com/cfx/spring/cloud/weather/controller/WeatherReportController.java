package com.cfx.spring.cloud.weather.controller;

import com.cfx.spring.cloud.weather.service.DataClient;
import com.cfx.spring.cloud.weather.service.WeatherReportService;
import com.cfx.spring.cloud.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: cfx
 * @Description:
 * @Date: Created in 2018/4/5 11:02
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception{
        //获取城市ID列表
        List<City> cityList = null;

        try {

            //由城市数据API微服务来提供服务
            cityList = dataClient.listCity();;

        } catch (Exception e) {
            logger.error("Exception!!",e);
        }

        model.addAttribute("title","mokeychan的天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityList);
        model.addAttribute("report",weatherReportService.getDataByCityId(cityId));

        return new ModelAndView("weather/report","reportModel",model);
    }


}
