package com.kangkang.store.controller;

import com.kangkang.store.service.CartService;
import com.kangkang.store.utils.JsonResult;
import com.kangkang.store.vo.CartVo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ClassName:CartController
 * Package:com.kangkang.store.controller
 * Description:
 *
 * @date:2022/3/28 10:04
 * @author:kangkang
 */
@RestController
@RequestMapping("/cart")
public class CartController extends BaseController {
    @Resource
    CartService cartService;

    @RequestMapping("/add")
    public JsonResult<Void> addCart(Integer pid, Integer amount, HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        cartService.addToCart(uid,pid,amount,username);
        return new JsonResult<>(OK);

    }

    @RequestMapping({"/",""})
    public JsonResult<List<CartVo>> findVo(HttpSession session){
        List<CartVo> data = cartService.findCartVoByUid(getUidFromSession(session));
        return new JsonResult<>(OK,data);
    }

    @RequestMapping("/add_num/{cid}")
    public JsonResult<Integer> addNum(@PathVariable Integer  cid,HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        Integer data = cartService.addNum(uid, username, cid);

        return new JsonResult<>(OK,data);
    }

    @RequestMapping("/list")
    public JsonResult<List<CartVo>> getVoByCid(HttpSession session,Integer[] cids){
        Integer uid = getUidFromSession(session);
        List<CartVo> data = cartService.getVOByCids(uid, cids);
        return new JsonResult<>(OK,data);
    }

}
