package com.baihe.service;

import com.baihe.entity.User;
import java.util.List;

/**
 * Created by Administrator on 2018/8/6.
 */
public interface UserService {
    User getOne(Integer id);
    List<User> getAll(Integer page, Integer rows);
    void addUser(User user);
    void changeUser(User user);
    void drop(Integer id);
}
