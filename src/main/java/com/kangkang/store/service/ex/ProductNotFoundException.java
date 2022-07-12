package com.kangkang.store.service.ex;

/**
 * ClassName:AddressCountLimitException
 * Package:com.kangkang.store.service.ex
 * Description:
 *
 * @date:2022/3/26 21:05
 * @author:kangkang
 */
//商品找不到
public class ProductNotFoundException extends ServiceException {
    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
