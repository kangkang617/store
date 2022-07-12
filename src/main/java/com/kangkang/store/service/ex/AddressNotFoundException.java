package com.kangkang.store.service.ex;

/**
 * ClassName:AddressCountLimitException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/26 21:05
 * @author:kangkang
 */
//地址找不到
public class AddressNotFoundException extends ServiceException {
    public AddressNotFoundException() {
        super();
    }

    public AddressNotFoundException(String message) {
        super(message);
    }

    public AddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
