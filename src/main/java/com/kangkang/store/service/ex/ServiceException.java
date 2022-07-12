package com.kangkang.store.service.ex;

/**
 * ClassName:ServiceException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/24 11:27
 * @author:kangkang
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
