package com.kangkang.store.service.ex;

/**
 * ClassName:AddressCountLimitException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/26 21:05
 * @author:kangkang
 */
//删除异常
public class DeleteException extends ServiceException {
    public DeleteException() {
        super();
    }

    public DeleteException(String message) {
        super(message);
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    protected DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
