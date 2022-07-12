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
 * 用户存在异常
 */
public class UsernameExistException extends RuntimeException {
    public UsernameExistException() {
        super();
    }

    public UsernameExistException(String message) {
        super(message);
    }

    public UsernameExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameExistException(Throwable cause) {
        super(cause);
    }

    protected UsernameExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
