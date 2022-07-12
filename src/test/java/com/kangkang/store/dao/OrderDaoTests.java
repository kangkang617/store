package com.kangkang.store.dao;

import com.kangkang.store.entity.Cart;
import com.kangkang.store.entity.Order;
import com.kangkang.store.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
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
//表示启动这个单元测试类，需要传递一个SpringExtension的实体类型
@RunWith(SpringRunner.class)
public class OrderDaoTests {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void testInsert() {
        Order order = new Order();
        order.setOrderTime(new Date());
        order.setUid(8);
        order.setTotalPrice(888L);
        order.setRecvName("kang");
        orderDao.insertOrder(order);
    }

    @Test
    public void testInsertItems() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setNum(66);
        orderItem.setPid(10000003);
        orderItem.setTitle("猪");

        orderDao.insertOrderItem(orderItem);
    }

}
