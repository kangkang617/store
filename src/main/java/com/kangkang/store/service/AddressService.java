package com.kangkang.store.service;

import com.kangkang.store.entity.Address;
import com.kangkang.store.entity.District;

import java.util.List;

/**
 * ClassName:AddressService
 * Package:com.kangkang.store.service
 * Description:
 *
 * @date:2022/3/26 21:06
 * @author:kangkang
 */
public interface AddressService {
//    添加收货地址
    void addAddress(Integer uid,String username,Address address);

//     根据uid查询用户的收获地址信息
    List<Address> findBuUid(Integer uid);

//    修改默认地址
    Integer ChangeDefault(Integer uid,Integer aid,String username);

//    删除地址
    void delete(Integer uid,Integer aid,String username);

    //    根据收货地址数据的id，查询收货地址详情
    Address getByAid(Integer aid, Integer uid);
}
