package com.kangkang.store.controller;

import com.kangkang.store.entity.Order;
import com.kangkang.store.service.OrderService;
import com.kangkang.store.utils.JsonResult;
import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * ClassName:OrderController
 * Package:com.kangkang.store.controller
 * Description:
 *
 * @date:2022/3/28 20:54
 * @author:kangkang
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Resource
    private OrderService orderService;


    @RequestMapping("/creat")
    public JsonResult<Order> creat(Integer aid, Integer[] cids, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        Order order = orderService.create(aid, cids, uid, username);

        return new JsonResult<>(OK,order);

    }

}
