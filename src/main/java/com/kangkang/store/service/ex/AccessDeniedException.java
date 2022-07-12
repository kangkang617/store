package com.kangkang.store.service.ex;

/**
 * ClassName:AddressCountLimitException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/26 21:05
 * @author:kangkang
 */
//非法访问
public class AccessDeniedException extends ServiceException {
    public AccessDeniedException() {
        super();
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccessDeniedException(Throwable cause) {
        super(cause);
    }

    protected AccessDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
