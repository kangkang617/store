package com.kangkang.store.utils;

/**
 * ClassName:JsonResult
 * Package:com.kangkang.store.utils
 * Description:
 *
 * @date:2022/3/24 15:07
 * @author:kangkang
 */

import java.io.Serializable;

/**
 * json格式进行响应
 */
public class JsonResult<T> implements Serializable {
//    状态码
    private Integer state;
//    错误信息
    private String message;
//    响应数据
    private T data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
