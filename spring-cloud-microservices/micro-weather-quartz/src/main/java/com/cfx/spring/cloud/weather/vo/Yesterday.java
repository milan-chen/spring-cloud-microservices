package com.cfx.spring.cloud.weather.vo;

import java.io.Serializable;

/**
 * @Author: cfx
 * @Description: 昨日天气类
 * @Date: Created in 2018/4/5 10:28
 */
public class Yesterday implements Serializable {

    private String date;

    private String high;

    private String fx;

    private String low;

    private String fl;

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

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
