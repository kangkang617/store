package com.kangkang.store.controller.ex;

/**
 * ClassName:FileUploadException
 * Package:com.kangkang.store.controller.ex
 * Description:
 *
 * @date:2022/3/26 16:16
 * @author:kangkang
 */
/** 文件上传相关异常的基类 */
public class FileUploadException extends RuntimeException {
    public FileUploadException() {
        super();
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
