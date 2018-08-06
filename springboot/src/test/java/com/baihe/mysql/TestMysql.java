package com.baihe.mysql;

import com.baihe.BaseTest;
import com.baihe.entity.User;
import com.baihe.service.UserService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/8/6.
 */
public class TestMysql extends BaseTest{

    @Resource
    public UserService userService;

    @Test
    public void tadd(){
        userService.addUser(new User(1,"yy","123123",25,false));
    }

    @Test
    public void getOne(){
        User user = userService.getOne(1);
        System.out.println(user);
    }
}
