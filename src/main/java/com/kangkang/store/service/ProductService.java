package com.kangkang.store.service;

import com.kangkang.store.entity.Product;

import java.util.List;

/**
 * ClassName:ProductService
 * Package:com.kangkang.store.service
 * Description:
 *
 * @date:2022/3/27 20:04
 * @author:kangkang
 */
public interface ProductService {
//     查找热销商品
    List<Product> findHotProduct();

//    id查商品
    Product findById(Integer id);
}
