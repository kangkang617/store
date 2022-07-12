package com.kangkang.store.dao;

import com.kangkang.store.entity.Cart;
import com.kangkang.store.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
public class CartDaoTests {

    @Autowired
    private CartDao cartDao;

    @Test
    public void testInsert() {
        Cart cart = new Cart();
        cart.setPrice(6666L);
        cart.setUid(8);
        cart.setPid(10000017);
        cart.setCreatedUser("wangwu");

        cartDao.insert(cart);
    }

    @Test
    public void testUpdate() {
        cartDao.updateCount(1,8,"kang",new Date());

    }

    @Test
    public void testByCid() {
        Integer [] arr = {1,2,3,4};
        List byCid = cartDao.findCartVoByCid(arr);
        System.out.println(byCid);

    }

}
