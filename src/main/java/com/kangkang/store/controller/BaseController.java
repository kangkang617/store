package com.kangkang.store.controller;

/**
 * ClassName:BaseController
 * Package:com.kangkang.store.controller
 * Description:
 *
 * @date:2022/3/24 20:10
 * @author:kangkang
 */

import com.kangkang.store.controller.ex.FileEmptyException;
import com.kangkang.store.controller.ex.FileSizeException;
import com.kangkang.store.controller.ex.FileStateException;
import com.kangkang.store.controller.ex.FileTypeException;
import com.kangkang.store.service.ex.*;
import com.kangkang.store.utils.JsonResult;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制层 类的基类
 */
public class BaseController {
    /**
     *操作成功状态码
     */
    public static final int OK = 200;


//    请求处理方法，这个方法的返回值就是需要传递给 前端的值
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>();
        result.setState(200);
        result.setMessage("登录成功！");


        if (e instanceof UsernameRepeatException){
            result.setState(666);
            result.setMessage("姓名已经存在了！");
        }else if (e instanceof InsertException){
            result.setState(888);
            result.setMessage("插入数据时服务器宕机！");
        }else if (e instanceof UsernameExistException){
            result.setState(887);
            result.setMessage("用户名已经存在");
        }else if (e instanceof PasswordCheckFailException){
            result.setState(889);
            result.setMessage("密码错误！");
        }else if (e instanceof UserExistException){
            result.setState(889);
            result.setMessage("用户不存在！");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }else if (e instanceof AddressCountLimitException) {
            result.setState(4003);
        }else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
        }else if (e instanceof DeleteException) {
            result.setState(5002);
        }else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
        }

        return result;
    }

//    获取session中的id
    protected final Integer getUidFromSession(HttpSession session){
        int uid = Integer.parseInt(session.getAttribute("uid").toString());
        return uid;
    }

    //    获取session中的usernaem
    protected final String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }

}
