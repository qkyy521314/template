package com.baihe.controller;

import com.baihe.entity.User;
import com.baihe.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/8/6.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Resource
    public UserService userService;

    @RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User getUser(@PathVariable Integer id){

        User user = userService.getOne(id);

        return user;
    }
    //  http://localhost:11111/user/addUser/"ee"/"211111"/23/false
    @RequestMapping(value = "/addUser/{name}/{password}/{age}/{sex}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addUser(@PathVariable String name,@PathVariable String password , @PathVariable Integer age,@PathVariable boolean sex){

        try {

            userService.addUser(new User(null,name,password,age,sex));
            return "ok";
        } catch (Exception e) {
            //e.printStackTrace();
            return "false";
        }
    }


}
