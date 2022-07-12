package com.kangkang.store.controller;

import com.kangkang.store.entity.District;
import com.kangkang.store.service.DistrictService;
import com.kangkang.store.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName:DistrictController
 * Package:com.kangkang.store.controller
 * Description:
 *
 * @date:2022/3/27 10:14
 * @author:kangkang
 */
@RestController
@RequestMapping("/district")
public class DistrictController extends BaseController{
    @Resource
    DistrictService districtService;

    @GetMapping({"/",""})
    public JsonResult<List<District>> getDistrict(String parent){
        List<District> data = districtService.findByParent(parent);
        return new JsonResult<>(OK,data);


    }



}
