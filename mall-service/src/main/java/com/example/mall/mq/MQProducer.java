package com.example.mall.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQProducer {


    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }


}
