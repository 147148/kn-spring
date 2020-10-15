package com.kenan.spring.expection;

import com.kenan.spring.enmu.ResultCode;

/**
 * @author kenan
 */
public interface IBusinessException {

    ResultCode getResultCode();

    static String createMessage(String format, Object... args) {
        String msg;
        if (format != null && args != null && args.length > 0) {
            msg = String.format( format, args );
        } else {
            msg = format;
        }
        return msg;
    }
}
