package com.kangkang.store.service.ex;

/**
 * ClassName:UsernameRepeatException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/24 11:29
 * @author:kangkang
 */
public class UsernameRepeatException extends ServiceException {
    public UsernameRepeatException() {
        super();
    }

    public UsernameRepeatException(String message) {
        super(message);
    }

    public UsernameRepeatException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameRepeatException(Throwable cause) {
        super(cause);
    }

    protected UsernameRepeatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
