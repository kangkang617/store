package com.kangkang.store.dao;

import com.kangkang.store.entity.Address;
import com.kangkang.store.entity.District;
import com.kangkang.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.net.idn.Punycode;

import java.util.Date;
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
public class AddressDaoTests {

    @Autowired
    private AddressDao addressDao;

    @Test
    public void testInsert() {
        Address address = new Address();
        address.setUid(9);
        address.setPhone("185555555555");
        address.setName("kang");
        addressDao.insert(address);
    }

    @Test
    public void testSearch(){
        Integer i = addressDao.SearchByUid(9);
        System.out.println(i);
    }

    @Test
    public void testFind(){
        List<Address> list = addressDao.findByUid(9);
        System.out.println(list);
    }

    @Test
    public void testSetAllNone(){
        addressDao.setAllNone(8);
    }

    @Test
    public void testSetDefault(){
        addressDao.setDefault(6,"kang",new Date());
    }

    @Test
    public void testDelete(){
        addressDao.delete(3);
    }

    @Test
    public void testLast(){
        Address lastModified = addressDao.findLastModified(8);
        System.out.println(lastModified);

    }
}
