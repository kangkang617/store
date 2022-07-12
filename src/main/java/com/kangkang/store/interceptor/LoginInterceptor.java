package com.kangkang.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:LoginInterceptor
 * Package:com.kangkang.store.interceptor
 * Description:
 *
 * @date:2022/3/25 13:40
 * @author:kangkang
 */



public class LoginInterceptor implements HandlerInterceptor {
    /**
     *  检测全局session对象中有没有uid，有则放行
     * @param request 请求
     * @param response 响应
     * @param handler 处理器
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object uid = request.getSession().getAttribute("uid");
        if (uid == null){
            response.sendRedirect("/web/login.html");
            return false;
        }

        return true;
    }
}
