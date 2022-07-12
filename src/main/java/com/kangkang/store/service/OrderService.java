package com.kangkang.store.service;

import com.kangkang.store.entity.Address;
import com.kangkang.store.entity.Order;

/**
 * ClassName:OrderService
 * Package:com.kangkang.store.service
 * Description:
 *
 * @date:2022/3/28 20:13
 * @author:kangkang
 */
public interface OrderService {

//    创建订单
    Order create(Integer aid, Integer[] cids, Integer uid, String username);

}
