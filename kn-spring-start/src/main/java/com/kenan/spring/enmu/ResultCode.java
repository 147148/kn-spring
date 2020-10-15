package com.kenan.spring.enmu;

/**
 * 异常错误码
 *
 * @author kenan
 */
public enum ResultCode {

    SERVER_ERROR(500, ""),
    DATA_ERROR(500, ""),
    THIRD_ERROR(500, ""),
    OTHER_ERROR(500, ""),
    ;

    private final int code;

    private final String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return code;
    }

    public String msg() {
        return msg;
    }
}
