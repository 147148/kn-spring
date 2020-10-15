package com.kenan.spring.bean;

/**
 * @author kenan
 */
public class CustomRefreshScopeBean {

    private String custom;

    private String msg;

    public String getCustom() {
        return custom;
    }

    public CustomRefreshScopeBean setCustom(String custom) {
        this.custom = custom;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public CustomRefreshScopeBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
