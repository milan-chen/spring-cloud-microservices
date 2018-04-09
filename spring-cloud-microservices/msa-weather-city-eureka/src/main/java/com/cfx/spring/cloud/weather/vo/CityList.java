package com.cfx.spring.cloud.weather.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author: cfx
 * @Description: 城市列表
 * @Date: Created in 2018/4/5 22:22
 */
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {

    @XmlElement(name = "d")
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
