package com.baihe.service;

import com.baihe.dao.UserDao;
import com.baihe.entity.User;
import com.baihe.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    public UserDao userDao;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Resource
    private RedisTemplate<Integer, User> redisTemplate;//key value 的泛型

    @Override
    public User getOne(Integer id) {
        User user=null;
        user = redisTemplate.opsForValue().get(id);
        if(user==null){
            user= userDao.selectOneByID(id);
            redisTemplate.opsForValue().set(user.getId(),user);
        }
        return user;
    }

    @Override
    public List<User> getAll(Integer page, Integer rows) {
        Integer pageStart = (page-1) * rows;
        return userDao.selectAll(pageStart,rows);
    }

    @Override
    public void addUser(User user) {
        Integer before_id = user.getId();
        userDao.insert(user);
        //在mapper文件做调整 即可返回自增id
        Integer after_id = user.getId();
        System.out.println("before_id="+before_id+"   after_id="+after_id);
        kafkaProducer.send("success add "+user);

    }

    @Override
    public void changeUser(User user) {
        userDao.update(user);
    }

    @Override
    public void drop(Integer id) {

        userDao.delete(id);
    }
}
