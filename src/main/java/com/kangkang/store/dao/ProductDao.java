package com.kangkang.store.dao;

import com.kangkang.store.entity.Product;

import java.util.List;

/**
 * ClassName:ProductDao
 * Package:com.kangkang.store.dao
 * Description:
 *
 * @date:2022/3/27 19:47
 * @author:kangkang
 */
public interface ProductDao {

//    查找销售较好的前四条记录
    List<Product> findHotProduct();

//    根据Id查商品
    Product findById(Integer id);
}
