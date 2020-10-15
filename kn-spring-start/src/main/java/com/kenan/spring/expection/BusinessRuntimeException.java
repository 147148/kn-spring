package com.kenan.spring.expection;

import com.kenan.spring.enmu.ResultCode;

/**
 * @author kenan
 */
public class BusinessRuntimeException extends Exception implements IBusinessException {

    private ResultCode result;

    public BusinessRuntimeException(ResultCode result) {
        super(result.msg());
        this.result = result;
    }

    public BusinessRuntimeException(ResultCode result, String message) {
        super(message);
        this.result = result;
    }

    public BusinessRuntimeException(ResultCode result, String message, Throwable cause) {
        super(message, cause);
        this.result = result;
    }

    public BusinessRuntimeException(ResultCode result, Throwable cause) {
        super(result.msg(), cause);
        this.result = result;
    }

    @Override
    public ResultCode getResultCode() {
        return result;
    }
}
