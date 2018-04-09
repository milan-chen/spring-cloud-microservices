package com.cfx.spring.cloud.weather.vo;

import java.io.Serializable;

/**
 * @Author: cfx
 * @Description: 天气接口响应
 * @Date: Created in 2018/4/5 10:35
 */
public class WeatherResponse implements Serializable{

    private Weather data;

    private Integer status;

    private String desc;

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
