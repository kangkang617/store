package com.kangkang.store.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:SecurityConfig
 * Package:com.kangkang.store.config
 * Description:
 *
 * @date:2022/6/7 17:21
 * @author:kangkang
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/bootstrap3/**","/css/**","/images/**","/js/**"
                ,"/web/login.html","/web/register.html","/web/index.html","/web/product.html"
                ,"/users/login", "/users/reg","/users/**" ,"/district/**","/product/**"  ).permitAll()
                .anyRequest().authenticated();
                /*.and()
                .formLogin()
                .loginPage("/web/login.html")
                .permitAll()
                .and()
                .logout()
                .permitAll();*/

        http.formLogin()    //自定义登录页面
                .loginPage("/web/login.html")    //登录页面设置
                .loginProcessingUrl("/users/login")   //点击登录后访问的路径
                .defaultSuccessUrl("/index").permitAll()   //登录成功后跳转路径,permitAll表示无条件进行访问
                .and().authorizeRequests()
//                .mvcMatchers("/","/hello","/user/login").permitAll() //设置不需要认证可以直接访问的路径
//                .anyRequest().authenticated()
                .and().csrf().disable();    //关闭csrf保护
    }
}
