package com.kangkang.store.dao;

import com.kangkang.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * ClassName:UserDao
 * Package:com.kangkang.store.dao
 * Description:
 *
 * @date:2022/3/24 9:33
 * @author:kangkang
 */
@Repository
public interface UserDao {
    //注册用户
    Integer addUser(User user);

    //按名字查询用户
    User findByUsername(String username);

//    修改密码操作
    Integer updatePassword(Integer uid, String password,
                           String modifiedUser, Date modifiedTime);

    //根据uid查用户信息
    User findByUid(Integer uid);

//    根据uid更新用户信息
    Integer updateInfo(User user);

//    更新头像信息
    Integer updateAvatar(Integer uid,String avatar,
                         String modifiedUser, Date modifiedTime);

}
