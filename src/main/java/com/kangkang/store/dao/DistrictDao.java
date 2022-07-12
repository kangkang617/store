package com.kangkang.store.dao;

import com.kangkang.store.entity.District;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:DistrictDao
 * Package:com.kangkang.store.dao
 * Description:
 *
 * @date:2022/3/27 8:52
 * @author:kangkang
 */
public interface DistrictDao {
//    获取下拉列表的值
    List<District> findByParent(String parent);

    //    根据code获取名字
    String getNameByCode(String code);

}
