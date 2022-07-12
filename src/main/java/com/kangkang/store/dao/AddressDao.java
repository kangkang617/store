package com.kangkang.store.dao;

import com.kangkang.store.entity.Address;
import com.kangkang.store.entity.District;

import java.util.Date;
import java.util.List;

/**
 * ClassName:AddressDao
 * Package:com.kangkang.store.dao
 * Description:
 *
 * @date:2022/3/26 20:54
 * @author:kangkang
 */
public interface AddressDao {
//    插入数据
    Integer insert (Address address);

//    统计当前uid下的所有用户数据
    Integer SearchByUid(Integer uid);

//    根据uid查询用户信息
    List<Address> findByUid(Integer uid);

//    查询地址存在不存在
    Address findByAId(Integer aid);

//    将所有的地址设置为非默认
    Integer setAllNone(Integer uid);

//    将某个地址设置为默认
    Integer setDefault(Integer aid, String modifiedUser, Date modifiedTime);

//    删除某个地址
    Integer delete(Integer aid);

//    选择某个地址为默认地址
    Address findLastModified(Integer uid);



}
