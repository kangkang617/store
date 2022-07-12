package com.kangkang.store.service;

import com.kangkang.store.dao.AddressDao;
import com.kangkang.store.entity.Address;
import com.kangkang.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Service;
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

//表示启动这个单元测试类，需要传递一个SpringRunner的实体类型
@RunWith(SpringRunner.class)
public class AddressServiceTests {

    @Autowired
    private AddressService addressService;

    @Test
    public void testInsert(){
        Address address  = new Address();
        address.setUid(8);
        address.setName("zhangsan");
        address.setProvinceCode("110100");
        address.setCityCode("110109");

        addressService.addAddress(8,"zhaoli",address);
    }

    @Test
    public void testFind(){
        List<Address> list = addressService.findBuUid(8);
        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    public void testChangeDefault(){
        addressService.ChangeDefault(8,10,"kang");

    }

    @Test
    public void testDelete(){
        addressService.delete(8,9,"kang");
    }

}
