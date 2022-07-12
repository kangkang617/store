package com.kangkang.store.controller;

import com.kangkang.store.entity.User;
import com.kangkang.store.service.UserService;
import com.kangkang.store.service.ex.InsertException;
import com.kangkang.store.service.ex.UsernameRepeatException;
import com.kangkang.store.utils.JsonResult;
import com.kangkang.store.utils.RandomFileName;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.File;

/**
 * ClassName:UserController
 * Package:com.kangkang.store.controller
 * Description:
 *
 * @date:2022/3/24 15:13
 * @author:kangkang
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    @Resource
    private UserService service;

    @RequestMapping("/reg")
    public JsonResult<Void> reg(User user){
        /*JsonResult<Void> result = new JsonResult<>();
        try {
            service.insertUser(user);
            result.setState(200);
            result.setMessage("注册成功");
        } catch (UsernameRepeatException e) {
            result.setState(555);
            result.setMessage("用户名已经存在");
        }catch (InsertException e){
            result.setState(666);
            result.setMessage("插入时异常");
        }*/

        service.insertUser(user);
        return new JsonResult<>(OK);

    }

    @RequestMapping("/login")
    public JsonResult login(String username,
                            String password,
                            HttpSession session){
        User login = service.login(username, password);

        session.setAttribute("uid",login.getUid());
        session.setAttribute("username",login.getUsername());

//        System.out.println(getUidFromSession(session));
//        System.out.println(getUsernameFromSession(session));

        return new JsonResult(200,login);

    }

    @RequestMapping("/change")
    public JsonResult changePassword(String oldPassword,String newPassword,
                                     HttpSession session){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        service.changePassword(uid,username,oldPassword,newPassword);

        return new JsonResult(OK);
    }


    /**根据用户ID查询并回显到页面的控制器方法*/
    @RequestMapping("/byuid")
    public JsonResult<User> getByUid(HttpSession session){
        Integer uid = getUidFromSession(session);
        User byUid = service.getByUid(uid);

        return new JsonResult<User>(OK,byUid);
    }

    /**根据用户ID修改信息*/
    @RequestMapping("/updateInfo")
    public JsonResult<Void> updateInfo(HttpSession session, User user){
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);



        service.updateInf(uid,username,user);

        return new JsonResult<>(OK);
    }

    /**
     *登出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public JsonResult login(HttpSession session){
        session.removeAttribute("uid");
        session.removeAttribute("username");
        session.removeAttribute("avatar");

        return new JsonResult(OK);
    }

    /**
     * 上传头像
     * @param session
     * @param filename
     * @return
     */
    @RequestMapping("/upload_avatar")
    public JsonResult<String> uploadAvatar(HttpSession session,
                                           @RequestParam("filename") String filename){
        /*RandomFileName.isCorrect(file);

//        获取当前项目的绝对路径
        String upload = session.getServletContext().getRealPath("upload");

        File dir = new File(upload);

        if (!dir.exists()){
            dir.mkdir();
        }

        String avatar = RandomFileName.getRandomName(file, dir);*/




        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);

        service.uploadAvatar(uid,username,filename);

        return new JsonResult<String>(OK,filename);


    }



}
