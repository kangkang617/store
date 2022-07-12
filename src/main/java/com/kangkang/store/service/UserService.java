package com.kangkang.store.service;

import com.kangkang.store.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ClassName:UserService
 * Package:com.kangkang.store.service
 * Description:
 *
 * @date:2022/3/24 11:26
 * @author:kangkang
 */
public interface UserService {

    /**
     * 注册
     * @param user
     */
    void insertUser(User user);

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    User login(String name,String password);

    /**
     * 更改密码
     * @param uid
     * @param username
     * @param oldPass
     * @param newPass
     * @return
     */
    Integer changePassword(Integer uid,String username,
                           String oldPass,String newPass);

    void updateInf(Integer uid,String username,
                   User user);

//    根据id查找用户
    User getByUid(Integer uid);

//    根据id上传头像
    Integer uploadAvatar(Integer uid,String username,
                         String avatar);


}
