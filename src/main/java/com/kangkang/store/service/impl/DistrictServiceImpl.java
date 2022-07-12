package com.kangkang.store.service.impl;

import com.kangkang.store.dao.DistrictDao;
import com.kangkang.store.entity.District;
import com.kangkang.store.service.DistrictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:DistrictServiceImpl
 * Package:com.kangkang.store.service.impl
 * Description:
 *
 * @date:2022/3/27 9:02
 * @author:kangkang
 */
@Service
public class DistrictServiceImpl implements DistrictService {

    @Resource
    DistrictDao districtDao;



    @Override
    public List<District> findByParent(String parent) {
        List<District> list = districtDao.findByParent(parent);

        for (District d : list){
            d.setParent(null);
            d.setId(null);
        }


        return list;
    }

    @Override
    public String getNameByCode(String code) {
        String name = districtDao.getNameByCode(code);
        return name;
    }
}
