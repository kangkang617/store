package com.kangkang.store.service;

import com.kangkang.store.entity.District;

import java.util.List;

/**
 * ClassName:DistrictService
 * Package:com.kangkang.store.service
 * Description:
 *
 * @date:2022/3/27 9:01
 * @author:kangkang
 */
public interface DistrictService {

//    根据Parent查找集合
    List<District> findByParent(String parent);

    //    根据地址code查用户名
    String getNameByCode(String  code);

}
