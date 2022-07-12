package com.kangkang.store.service;

import com.kangkang.store.dao.CartDao;
import com.kangkang.store.entity.Address;
import com.kangkang.store.entity.Cart;
import com.kangkang.store.vo.CartVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
public class CartServiceTests {

    @Autowired
    private CartService cartService;

    @Test
    public void testInsert(){
        cartService.addToCart(8,10000017,66,"kang");
    }

    @Test
    public void testFind(){
        List<CartVo> cartVoByUid = cartService.findCartVoByUid(8);
        System.out.println(cartVoByUid);
    }

    @Test
    public void testAdd(){
        cartService.addNum(8,"kang",2);

    }

    @Test
    public void testCids(){
        Integer[] i = {1,2,3,4};

        List<CartVo> voByCids = cartService.getVOByCids(8, i);
        System.out.println(voByCids);
    }
}
