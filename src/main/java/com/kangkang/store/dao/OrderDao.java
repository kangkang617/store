package com.kangkang.store.dao;

import com.kangkang.store.entity.Order;
import com.kangkang.store.entity.OrderItem;

/**
 * ClassName:OrderDao
 * Package:com.kangkang.store.dao
 * Description:
 *
 * @date:2022/3/28 20:01
 * @author:kangkang
 */
public interface OrderDao {

//    添加订单
    Integer insertOrder(Order order);

    /**
     * 插入订单商品数据
     * @param orderItem 订单商品数据
     * @return 受影响的行数
     */
    Integer insertOrderItem(OrderItem orderItem);

}
