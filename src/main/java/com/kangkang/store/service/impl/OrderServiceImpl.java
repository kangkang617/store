package com.kangkang.store.service.impl;

import com.kangkang.store.dao.OrderDao;
import com.kangkang.store.entity.Address;
import com.kangkang.store.entity.Order;
import com.kangkang.store.entity.OrderItem;
import com.kangkang.store.service.AddressService;
import com.kangkang.store.service.CartService;
import com.kangkang.store.service.OrderService;
import com.kangkang.store.service.ex.InsertException;
import com.kangkang.store.vo.CartVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * ClassName:OrderServiceImpl
 * Package:com.kangkang.store.service.impl
 * Description:
 *
 * @date:2022/3/28 20:14
 * @author:kangkang
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private AddressService addressService;
    @Resource
    private CartService cartService;

    @Override
    public Order create(Integer aid, Integer[] cids, Integer uid, String username) {
//        下单时间
        Date date = new Date();
//        获取购物车的信息
        List<CartVo> carts = cartService.getVOByCids(uid, cids);

        long totalPrice = 0;
        for (CartVo cartVo : carts){
            totalPrice += cartVo.getPrice() * cartVo.getNum();
        }

//        创建订单对象并补全数据
        Order order = new Order();
        order.setUid(uid);
        Address address = addressService.getByAid(aid, uid);
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvCity(address.getCityName());
        order.setRecvAddress(address.getAreaName());
        order.setRecvArea(address.getAreaName());

        order.setTotalPrice(totalPrice);
        order.setOrderTime(date);


        // 补全数据：日志
        order.setCreatedUser(username);
        order.setCreatedTime(date);
        order.setModifiedUser(username);
        order.setModifiedTime(new Date());


        Integer result = orderDao.insertOrder(order);
        if (result != 1){
            throw new InsertException("插入数据异常");
        }
        // 遍历carts，循环插入订单商品数据
        for (CartVo cart : carts) {
            // 创建订单商品数据
            OrderItem item = new OrderItem();
            // 补全数据：setOid(order.getOid())
            item.setOid(order.getOid());
            // 补全数据：pid, title, image, price, num
            item.setPid(cart.getPid());
            item.setTitle(cart.getTitle());
            item.setImage(cart.getImage());
            item.setPrice(cart.getRealPrice());
            item.setNum(cart.getNum());
            // 补全数据：4项日志
            item.setCreatedUser(username);
            item.setCreatedTime(date);
            item.setModifiedUser(username);
            item.setModifiedTime(date);
            // 插入订单商品数据
            Integer rows2 = orderDao.insertOrderItem(item);
            if (rows2 != 1) {
                throw new InsertException("插入订单商品数据时出现未知错误，请联系系统管理员");
            }
        }

        // 返回
        return order;

    }
}
