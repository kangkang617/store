package com.kangkang.store.dao;

import com.kangkang.store.entity.District;
import com.kangkang.store.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * ClassName:UserDaoTests
 * Package:com.kangkang.store.Dao
 * Description:
 *
 * @date:2022/3/24 10:06
 * @author:kangkang
 */
//标注当前类为测试类
@SpringBootTest
//表示启动这个单元测试类，需要传递一个SpringExtension的实体类型
@RunWith(SpringRunner.class)
public class ProductDaoTests {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testFindHot() {
        List<Product> hotProduct = productDao.findHotProduct();
        System.out.println(hotProduct);

    }

    @Test
    public void testFindById(){
        Product byId = productDao.findById(10000017);
        System.out.println(byId);
    }

}
