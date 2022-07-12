package com.kangkang.store.service.impl;

import com.kangkang.store.dao.ProductDao;
import com.kangkang.store.entity.Product;
import com.kangkang.store.service.ProductService;
import com.kangkang.store.service.ex.ProductNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:ProductServiceImpl
 * Package:com.kangkang.store.service.impl
 * Description:
 *
 * @date:2022/3/27 20:06
 * @author:kangkang
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductDao productDao;

    @Override
    public List<Product> findHotProduct() {
        List<Product> list = productDao.findHotProduct();

        for (Product product : list ){
            product.setPriority(null);
            product.setCreatedUser(null);
            product.setCreatedTime(null);
            product.setModifiedUser(null);
            product.setModifiedTime(null);
        }

        return list;
    }

    @Override
    public Product findById(Integer id) {
        Product product = productDao.findById(id);
        if (product == null){
            throw new ProductNotFoundException("商品不存在");
        }

        // 将查询结果中的部分属性设置为null
        product.setPriority(null);
        product.setCreatedUser(null);
        product.setCreatedTime(null);
        product.setModifiedUser(null);
        product.setModifiedTime(null);

        return product;


    }


}
