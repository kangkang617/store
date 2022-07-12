package com.kangkang.store.dao;

import com.kangkang.store.entity.Cart;
import com.kangkang.store.vo.CartVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * ClassName:CartDao
 * Package:com.kangkang.store.dao
 * Description:
 *
 * @date:2022/3/27 20:44
 * @author:kangkang
 */
public interface CartDao {
//    向购物车插入数据
    Integer insert(Cart cart);

//    修改购物车的数量
    Integer updateCount(Integer cid, Integer num,
                        String modifiedUser, Date modifiedTime );

//    查询购物车的数据
    Cart findByPidAndUid(@Param("pid") Integer pid,
                         @Param("uid") Integer uid);

//    查找购物车对象
    List<CartVo> findCartVoByUid(Integer uid);

    Cart getByCid(Integer cid);

    List<CartVo> findCartVoByCid(Integer[] cids);
}
