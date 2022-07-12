package com.kangkang.store.controller.ex;

/**
 * ClassName:FileTypeException
 * Package:com.kangkang.store.controller.ex
 * Description:
 *
 * @date:2022/3/26 16:19
 * @author:kangkang
 */
public class FileTypeException extends FileUploadException {
    public FileTypeException() {
        super();
    }

    public FileTypeException(String message) {
        super(message);
    }

    public FileTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileTypeException(Throwable cause) {
        super(cause);
    }

    protected FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
