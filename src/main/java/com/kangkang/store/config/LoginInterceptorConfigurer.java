package com.kangkang.store.config;

/**
 * ClassName:LoginInterceptorConfigurer
 * Package:com.kangkang.store.config
 * Description:
 *
 * @date:2022/3/25 13:47
 * @author:kangkang
 */

import com.kangkang.store.interceptor.LoginInterceptor;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理器拦截器的注册
 */
@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    //创建自定义的拦截器对象
    HandlerInterceptor interceptor = new LoginInterceptor();



    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> patterns = new ArrayList<>();
        patterns.add("/bootstrap3/**");
        patterns.add("/css/**");
        patterns.add("/images/**");
        patterns.add("/js/**");
        patterns.add("/web/login.html");
        patterns.add("/web/register.html");
        patterns.add("/web/index.html");
        patterns.add("/web/product.html");
        patterns.add("/users/login");
        patterns.add("/users/reg");
        patterns.add("/users/**");
        patterns.add("/district/**");
        patterns.add("/product/**");

        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(patterns);
    }*/
}
