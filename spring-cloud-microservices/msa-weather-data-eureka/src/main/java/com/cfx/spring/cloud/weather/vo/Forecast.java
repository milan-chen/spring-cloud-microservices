package com.cfx.spring.cloud.weather.vo;

import java.io.Serializable;

/**
 * @Author: cfx
 * @Description: 未来天气
 * @Date: Created in 2018/4/5 10:30
 */
public class Forecast implements Serializable {

    private String date;

    private String high;

    private String fengli;

    private String low;

    private String fengxiang;

    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
