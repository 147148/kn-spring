package com.kenan.spring.expection;

import com.kenan.spring.enmu.ResultCode;

/**
 * @author kenan
 */
public class DataException extends BusinessRuntimeException {

    public DataException(String message) {
        super(ResultCode.DATA_ERROR, message);
    }

    public DataException(ResultCode result, String message) {
        super(result, message);
    }

    public DataException(ResultCode result, String message, Throwable cause) {
        super(result, message, cause);
    }

    public DataException(ResultCode result, Throwable cause) {
        super(result, cause);
    }
}
