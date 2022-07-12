package com.kangkang.store.service.ex;

/**
 * ClassName:AddressCountLimitException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/26 21:05
 * @author:kangkang
 */
public class AddressCountLimitException extends ServiceException {
    public AddressCountLimitException() {
        super();
    }

    public AddressCountLimitException(String message) {
        super(message);
    }

    public AddressCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressCountLimitException(Throwable cause) {
        super(cause);
    }

    protected AddressCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
