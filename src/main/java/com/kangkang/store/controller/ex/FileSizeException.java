package com.kangkang.store.controller.ex;

/**
 * ClassName:FileSizeException
 * Package:com.kangkang.store.controller.ex
 * Description:
 *
 * @date:2022/3/26 16:18
 * @author:kangkang
 */
public class FileSizeException extends FileUploadException {
    public FileSizeException() {
        super();
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    protected FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
