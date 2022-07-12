package com.kangkang.store.controller.ex;

/**
 * ClassName:FileStateException
 * Package:com.kangkang.store.controller.ex
 * Description:
 *
 * @date:2022/3/26 16:19
 * @author:kangkang
 */
public class FileStateException extends FileUploadException {
    public FileStateException() {
        super();
    }

    public FileStateException(String message) {
        super(message);
    }

    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
