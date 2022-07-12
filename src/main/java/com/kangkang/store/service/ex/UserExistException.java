package com.kangkang.store.service.ex;

/**
 * ClassName:InsertException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/24 11:30
 * @author:kangkang
 */

/**
 * 用户名存在异常
 */
public class UserExistException extends RuntimeException {
    public UserExistException() {
        super();
    }

    public UserExistException(String message) {
        super(message);
    }

    public UserExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserExistException(Throwable cause) {
        super(cause);
    }

    protected UserExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
