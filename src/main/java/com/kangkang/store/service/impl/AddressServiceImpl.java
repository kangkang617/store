package com.kangkang.store.service.impl;

import com.kangkang.store.dao.AddressDao;
import com.kangkang.store.entity.Address;
import com.kangkang.store.entity.District;
import com.kangkang.store.service.AddressService;
import com.kangkang.store.service.DistrictService;
import com.kangkang.store.service.ex.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * ClassName:AddressServiceImpl
 * Package:com.kangkang.store.service.impl
 * Description:
 *
 * @date:2022/3/26 21:07
 * @author:kangkang
 */
@Service
public class AddressServiceImpl implements AddressService {
//    添加Mapper对象
    @Resource
    AddressDao addressDao;

    @Resource
    DistrictService districtService;

    @Value("${user.address.max-count}")
    private int maxCount;

    @Override
    public void addAddress(Integer uid,String username,Address address) {
        Integer con = addressDao.SearchByUid(uid);
        if (con >= maxCount){
            throw new AddressCountLimitException("收货地址数量超出限制");
        }

        String provinceName = districtService.getNameByCode(address.getProvinceCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String areaName = districtService.getNameByCode(address.getAreaCode());

        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        address.setUid(uid);
        address.setName(username);
        address.setModifiedUser(username);
        address.setModifiedTime(new Date());

        Integer isDefault = con == 0 ? 1:0;
        address.setIsDefault(isDefault);

        Integer insert = addressDao.insert(address);
        if (insert != 1){
            throw new InsertException("插入数据异常");
        }


    }

    @Override
    public List<Address> findBuUid(Integer uid) {
        List<Address> list = addressDao.findByUid(uid);
        for (Address address : list){
            address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setCreatedUser(null);
            address.setCreatedTime(null);
            address.setModifiedUser(null);
            address.setModifiedTime(null);
        }

        return list;
    }

    @Override
    public Integer ChangeDefault(Integer uid, Integer aid, String username) {
        Address byAId = addressDao.findByAId(aid);
        if (aid == null){
            throw new AddressNotFoundException("地址不存在");
        }

        if (byAId.getUid() != uid){
            throw  new AccessDeniedException("数据访问异常");
        }

        addressDao.setAllNone(uid);

        Integer result = addressDao.setDefault(aid, username, new Date());
        if (result != 1){
            throw new InsertException("更新失败");
        }
        return result;
    }

    @Override
    public void delete(Integer uid, Integer aid, String username) {
        Address byAId = addressDao.findByAId(aid);
        Integer delete = null;
        if (uid != byAId.getUid()){
            throw  new AccessDeniedException("非法访问");
        }

        if (aid == null){
            throw  new AddressNotFoundException("地址不存在，无法删除");
        }
        if (byAId.getIsDefault() == 1){
            if (addressDao.SearchByUid(uid) == 1){
                addressDao.delete(aid);
            }else {
                delete = addressDao.delete(aid);
                Address lastModified = addressDao.findLastModified(uid);
                Integer lastAid = lastModified.getAid();
                addressDao.setDefault(lastAid,username,new Date());
            }

        }else{
            addressDao.delete(aid);
        }

        if (delete != null && delete != 1){
            throw new DeleteException("删除失败");
        }

    }

    @Override
    public Address getByAid(Integer aid, Integer uid) {
        Address byAId = addressDao.findByAId(aid);

        if (byAId == null){
            throw new AddressNotFoundException("地址访问异常");
        }

        if (byAId.getUid() != uid){
            throw  new AccessDeniedException("访问异常");
        }

        byAId.setProvinceCode(null);
        byAId.setCityCode(null);
        byAId.setAreaCode(null);
        byAId.setCreatedTime(null);
        byAId.setCreatedUser(null);
        byAId.setModifiedTime(null);
        byAId.setModifiedUser(null);

        return byAId ;
    }
}
