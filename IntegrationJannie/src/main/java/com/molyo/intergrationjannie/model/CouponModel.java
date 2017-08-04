package com.molyo.intergrationjannie.model;

/**
 * Created by hongchong on 2017/8/4.
 */
public class CouponModel {
    private int id;
    private String code;
    private String mobile;
    private String isused;
    private String ip;
    private String fetchtime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIsused() {
        return isused;
    }

    public void setIsused(String isused) {
        this.isused = isused;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFetchtime() {
        return fetchtime;
    }

    public void setFetchtime(String fetchtime) {
        this.fetchtime = fetchtime;
    }
}
