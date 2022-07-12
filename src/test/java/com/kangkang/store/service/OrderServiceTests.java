package com.kangkang.store.service;

import com.kangkang.store.entity.District;
import com.kangkang.store.entity.Order;
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
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void testFind(){
        orderService.create(7,new Integer[]{1,2,3},8,"kang");
    }

}
