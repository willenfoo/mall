package com.example.mall.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQProducer {


    @RabbitListener(queues = "hello")
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }


}
