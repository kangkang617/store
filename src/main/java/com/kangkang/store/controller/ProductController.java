package com.kangkang.store.controller;

import com.kangkang.store.entity.Product;
import com.kangkang.store.service.ProductService;
import com.kangkang.store.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:ProductController
 * Package:com.kangkang.store.controller
 * Description:
 *
 * @date:2022/3/27 20:09
 * @author:kangkang
 */

@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {
    @Resource
    ProductService productService;

    @RequestMapping("/get_hot")
    public JsonResult<List<Product>> getHotProduct(){
        List<Product> list = productService.findHotProduct();
        return new JsonResult<>(OK,list);
    }

    @RequestMapping("/details{id}")
    public JsonResult<Product> getById(@PathVariable Integer id){
        Product product = productService.findById(id);

        return new JsonResult<>(OK,product);
    }

}
