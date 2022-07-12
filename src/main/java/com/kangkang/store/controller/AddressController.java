package com.kangkang.store.controller;

import com.kangkang.store.entity.Address;
import com.kangkang.store.service.AddressService;
import com.kangkang.store.utils.JsonResult;
import com.sun.net.httpserver.HttpsServer;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:AddressController
 * Package:com.kangkang.store.controller
 * Description:
 *
 * @date:2022/3/26 21:26
 * @author:kangkang
 */

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController {
//    声明创建service对象
    @Resource
    AddressService addressService;


    @RequestMapping("/add")
    public JsonResult<Void> addAddress(HttpSession session, Address address){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        addressService.addAddress(uid,username,address);

        return new JsonResult<>(OK);


    }


    @GetMapping({"/",""})
    public JsonResult<List<Address>> getById(HttpSession session){
        Integer uid = getUidFromSession(session);
        List<Address> data = addressService.findBuUid(uid);

        return new JsonResult<List<Address>>(OK,data);

    }

    @GetMapping("/change_default/{aid}")
    public JsonResult<Void> changDefault(@PathVariable("aid") Integer aid, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.ChangeDefault(uid,aid,username);

        return new JsonResult<>(OK);

    }

    @RequestMapping("/delete/{aid}")
    public JsonResult<Void> delete(@PathVariable Integer aid,HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        addressService.delete(uid,aid,username);

        return new JsonResult<>(OK);


    }




}
