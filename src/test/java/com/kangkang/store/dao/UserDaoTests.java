package com.kangkang.store.dao;

import com.kangkang.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * ClassName:UserDaoTests
 * Package:com.kangkang.store.Dao
 * Description:
 *
 * @date:2022/3/24 10:06
 * @author:kangkang
 */
//标注当前类为测试类
@SpringBootTest
//表示启动这个单元测试类，需要传递一个SpringExtension的实体类型
@RunWith(SpringRunner.class)
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("lisi");
        user.setPassword("kangkang");
        Integer result = userDao.addUser(user);
        System.out.println(result);

    }

    @Test
    public void testFindByUsername(){
        User kangkang = userDao.findByUsername("zhangsan2");
        System.out.println(kangkang);
    }

    @Test
    public void testUpdatePassword(){
        userDao.updatePassword(3,"666","kang",new Date());
    }

    @Test
    public void testFindByUid() {
        System.out.println(userDao.findByUid(3));;
    }

    @Test
    public void testUpdateInfo(){


        User user = new User();

        user.setUid(6);
        user.setPhone("666666666666");
        user.setEmail("kangkang@qq.com");
        user.setGender(1);
        user.setModifiedTime(new Date());
        user.setModifiedUser("kang");

        userDao.updateInfo(user);
    }

    @Test
    public void testUpdateAvatar(){
        userDao.updateAvatar(9,"/home","kang",new Date());
    }

}
