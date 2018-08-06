package com.baihe.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;

/**
 * Created by Administrator on 2018/8/6.
 */
@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String message){

        ListenableFuture future = kafkaTemplate.send("user", message);
        future.addCallback(o -> System.out.println("生产者：send-生产消息：" + message), throwable -> System.out.println("消息发送失败：" + message));

    }

}
