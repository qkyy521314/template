package com.baihe.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/8/6.
 */
@Component
public class KafkaConsumer {

    @KafkaListener(topics = {"user"})
    public void receive(String message){

        System.out.println("消费者：receive--消费消息:" + message);

    }

}


