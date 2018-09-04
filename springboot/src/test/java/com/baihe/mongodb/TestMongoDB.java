package com.baihe.mongodb;

import com.baihe.BaseTest;
import com.baihe.dao.UserRepository;
import com.baihe.entity.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/8/22.
 */
public class TestMongoDB extends BaseTest {
    @Resource
    private UserRepository userRepository;

    @Test
    public void add(){
        User user = new User(2, "qq", "12324", 12, false);
        userRepository.save(user);
        User one = userRepository.findUsersByName("qq");
        System.out.println(one);
    }
}
