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
 * 密码校验失败的异常
 */
public class PasswordCheckFailException extends RuntimeException {
    public PasswordCheckFailException() {
        super();
    }

    public PasswordCheckFailException(String message) {
        super(message);
    }

    public PasswordCheckFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordCheckFailException(Throwable cause) {
        super(cause);
    }

    protected PasswordCheckFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
