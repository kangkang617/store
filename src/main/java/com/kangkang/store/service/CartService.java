package com.kangkang.store.service;

import com.kangkang.store.vo.CartVo;

import java.util.List;

/**
 * ClassName:CartService
 * Package:com.kangkang.store.service
 * Description:
 *
 * @date:2022/3/27 21:02
 * @author:kangkang
 */
public interface CartService {
//    添加购物车
    void addToCart(Integer uid, Integer pid,
                   Integer amount, String username);

//    显示购物车
    List<CartVo> findCartVoByUid(Integer uid);

//    添加数量
    Integer addNum(Integer uid,String username,Integer cid);

    List<CartVo> getVOByCids(Integer uid,Integer[] cids);
}
