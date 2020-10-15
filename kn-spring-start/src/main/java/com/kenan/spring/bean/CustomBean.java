package com.kenan.spring.bean;

/**
 * @author kenan
 */
public class CustomBean {

    private String custom;

    private String msg;

    public String getCustom() {
        return custom;
    }

    public CustomBean setCustom(String custom) {
        this.custom = custom;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public CustomBean setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
