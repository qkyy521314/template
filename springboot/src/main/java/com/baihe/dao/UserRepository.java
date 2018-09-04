package com.baihe.dao;

import com.baihe.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/8/22.
 */
public interface UserRepository extends MongoRepository<User, Integer> {

    User findUsersByName(String name);

}
