package com.kangkang.store.service.impl;

import com.kangkang.store.dao.CartDao;
import com.kangkang.store.entity.Cart;
import com.kangkang.store.entity.Product;
import com.kangkang.store.service.CartService;
import com.kangkang.store.service.ProductService;
import com.kangkang.store.service.ex.AccessDeniedException;
import com.kangkang.store.service.ex.InsertException;
import com.kangkang.store.service.ex.ProductNotFoundException;
import com.kangkang.store.vo.CartVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * ClassName:CartServiceImpl
 * Package:com.kangkang.store.service.impl
 * Description:
 *
 * @date:2022/3/27 21:04
 * @author:kangkang
 */
@Service
public class CartServiceImpl implements CartService {
    @Resource
    CartDao cartDao;
    @Resource
    ProductService productService;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        Cart cart = cartDao.findByPidAndUid(pid, uid);

        if (cart == null){
//            Integer cid = cart.getCid();
            Cart c = new Cart();
            c.setPid(pid);
            c.setUid(uid);
            c.setModifiedTime(new Date());
            c.setModifiedUser(username);
            c.setNum(amount);
            Product product = productService.findById(pid);
            c.setPrice(product.getPrice());
            c.setCreatedTime(new Date());
            c.setCreatedUser(username);

            Integer insert = cartDao.insert(c);
            if (insert == null){
                throw new InsertException("插入异常");
            }
        }else {
            Integer cid = cart.getCid();
            Integer num = cart.getNum() + amount;

            Integer count = cartDao.updateCount(cid, num, username, new Date());
            if (count != 1){
                throw new InsertException("更新失败");
            }
        }

    }

    @Override
    public List<CartVo> findCartVoByUid(Integer uid) {
        return cartDao.findCartVoByUid(uid);
    }

    @Override
    public Integer addNum(Integer uid, String username, Integer cid) {
        Cart byCid = cartDao.getByCid(cid);
        if (byCid == null){
            throw new ProductNotFoundException("商品不存在！");
        }

        if (byCid.getUid() != uid){
            throw new AccessDeniedException("非法访问");
        }

        Integer num = byCid.getNum();
        num++;

        Integer count = cartDao.updateCount(cid, num, username, new Date());

        if (count != 1){
            throw new InsertException("插入时异常");
        }


        return num;
    }

    @Override
    public List<CartVo> getVOByCids(Integer uid, Integer[] cids) {
        List<CartVo> list = cartDao.findCartVoByCid(cids);

        Iterator<CartVo> iterator = list.iterator();

        while (iterator.hasNext()){
            CartVo cart = iterator.next();
            if (cart.getUid() != uid){
                iterator.remove();
            }
        }

        return list;
    }
}
