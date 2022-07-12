package com.kangkang.store.controller.ex;

/**
 * ClassName:FileEmptyException
 * Package:com.kangkang.store.controller.ex
 * Description:
 *
 * @date:2022/3/26 16:17
 * @author:kangkang
 */
//文件为空的异常
public class FileEmptyException extends FileUploadException {
    public FileEmptyException() {
        super();
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    protected FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
