package com.kangkang.store.service;

import com.kangkang.store.entity.User;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

//表示启动这个单元测试类，需要传递一个SpringRunner的实体类型
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("zhangsan2");
        user.setPassword("kangkang");
        userService.insertUser(user);

    }

    @Test
    public void testLogin(){
        User login = userService.login("zhangsan2", "kangkang");
        System.out.println(login);
    }

    @Test
    public void testChangePassword(){
        userService.changePassword(8,"kang","kangkang","lisi");
    }

    @Test
    public void testUpdateInfo(){
        userService.updateInf(8,"kang",new User());

    }

}
