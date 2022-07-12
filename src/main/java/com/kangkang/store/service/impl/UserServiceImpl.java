package com.kangkang.store.service.impl;

import com.kangkang.store.dao.UserDao;
import com.kangkang.store.entity.User;
import com.kangkang.store.service.UserService;
import com.kangkang.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * ClassName:UserServiceImpl
 * Package:com.kangkang.store.service.impl
 * Description:
 *
 * @date:2022/3/24 11:32
 * @author:kangkang
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User getByUid(Integer uid) {

        User byUid = userDao.findByUid(uid);

        if (byUid == null){
            throw new UserExistException("用户不存在");
        }

        return byUid;
    }

    /**
     * 更改头像
     * @param uid
     * @param username
     * @param filename
     * @return
     */
    @Override
    public Integer uploadAvatar(Integer uid, String username,String filename) {
        User user1 = getByUid(uid);
        if (user1 == null){
            throw new UserExistException("用户不存在");
        }

        Integer integer = userDao.updateAvatar(uid, "https://kang-agricultural-1253599123.cos.ap-beijing.myqcloud.com/avatar/" + filename + ".jpg", username, new Date());

        if (integer !=1){
            throw new InsertException("更新失败");
        }
        return integer;
    }

    /**
     * 注册用户
     * @param user
     */
    @Override
    public void insertUser(User user) {
        String username = user.getUsername();
//        判断username是否被注册过
        User byUsername = userDao.findByUsername(username);
        if (byUsername != null){
            throw new UsernameRepeatException();
        }
//        生成盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
//        保存盐值
        user.setSalt(salt);
//        得到加密后的密码
        String md5Password = getMD5Password(user.getPassword(), salt);
        user.setPassword(md5Password);


//        添加完整信息
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        user.setCreatedTime(new Date());
        user.setModifiedTime(new Date());
        user.setIsDelete(0);


        Integer result = userDao.addUser(user);

        if (result != 1){
            throw new InsertException();
        }

    }

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public User login(String name, String password) {
        User user = userDao.findByUsername(name);
        if (user == null ){
            throw new UsernameExistException("用户名不存在");
        }
//        System.out.println(user.getIsDelete());
//        if (1 == user.getIsDelete() ){
//            throw new UsernameExistException("用户名已被删除");
//        }


//        获取盐值
        String salt = user.getSalt();
//        比对密码
        String oldPass = user.getPassword();
        String newPass = getMD5Password(password,salt);

        if (!oldPass.equals(newPass)){
            throw new PasswordCheckFailException("用户密码错误");
        }

        User result = new User();
        result.setUid(user.getUid());
        result.setUsername(user.getUsername());
        result.setAvatar(user.getAvatar());

        return result;


    }

    @Override
    public Integer changePassword(Integer uid, String username, String oldPass, String newPass) {
//        查看用户是否存在
        User byUid = userDao.findByUid(uid);
        if (byUid == null /*|| byUid.getIsDelete() == 1*/){
            throw new UserExistException("用户不存在");
        }

//        获取加密后的密码和输入的原密码比较
        String md5OldPassword = getMD5Password(oldPass, byUid.getSalt());
        if (!byUid.getPassword().equals(md5OldPassword)){
            throw new PasswordCheckFailException("原密码不正确");
        }

//        修改密码
        String md5NewPassword = getMD5Password(newPass, byUid.getSalt());
        userDao.updatePassword(uid,md5NewPassword,username,new Date());


        return null;
    }

    @Override
    public void updateInf(Integer uid, String username,User user) {
//        判断uid的用户是否存在
        User byUid = userDao.findByUid(uid);
        if (byUid == null){
            throw new UserExistException("用户不存在");
        }

//        进行更改

        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());

        userDao.updateInfo(user);


    }

    //    定义一个MD5加密的方法
    public String getMD5Password(String password,String salt){

        for (int i=0;i<3;i++){
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }

        return password;



    }



}
