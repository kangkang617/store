package com.kangkang.store.service.ex;

/**
 * ClassName:InsertException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/24 11:30
 * @author:kangkang
 */
public class InsertException extends RuntimeException {
    public InsertException() {
        super();
    }

    public InsertException(String message) {
        super(message);
    }

    public InsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertException(Throwable cause) {
        super(cause);
    }

    protected InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
