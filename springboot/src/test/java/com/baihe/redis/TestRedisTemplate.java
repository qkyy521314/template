package com.baihe.redis;

import javax.annotation.Resource;

import com.baihe.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.TimeUnit;

@WebAppConfiguration
public class TestRedisTemplate extends BaseTest {
    @Resource
    private RedisTemplate<String, String> redisTemplate;//key value 的泛型


    @Test
    public void testadd(){
        //redisTemplate.opsForValue().set("abc","123");
        String a = redisTemplate.opsForValue().get("abc");
        System.out.println(a);
    }

    @Test
    public void  testRedisTemplateex() throws InterruptedException {

        redisTemplate.opsForValue().set("a","1",10,TimeUnit.SECONDS);
        Thread.sleep(1000);
        redisTemplate.expire("abc",10,TimeUnit.SECONDS);
    }

    @Test
    public void  testRedisTemplate(){

        redisTemplate.opsForValue().set("test", "100",60*10, TimeUnit.SECONDS);//向redis里存入数据和设置缓存时间

        redisTemplate.boundValueOps("test").increment(-1);//val做-1操作

        redisTemplate.opsForValue().get("test");//根据key获取缓存中的val

        redisTemplate.boundValueOps("test").increment(1);//val +1

        redisTemplate.getExpire("test");//根据key获取过期时间

        redisTemplate.getExpire("test",TimeUnit.SECONDS);//根据key获取过期时间并换算成指定单位

        redisTemplate.delete("test");//根据key删除缓存

        redisTemplate.hasKey("546545");//检查key是否存在，返回boolean值

        redisTemplate.opsForSet().add("red_123", "1","2","3");//向指定key中存放set集合

        redisTemplate.expire("red_123",1000 , TimeUnit.MILLISECONDS);//设置过期时间

        redisTemplate.opsForSet().isMember("red_123", "1");//根据key查看集合中是否存在指定数据

    }
}

