package com.example.mall.mq;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class MQConfirm implements RabbitTemplate.ConfirmCallback {

    public MQConfirm(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData data, boolean ack, String cause) {
        System.out.println("消息确认:" + data);
        if (!ObjectUtils.isEmpty(data)) {
            System.out.println("消息id:" + data.getId());
            if (ack) {
                System.out.println("消息发送确认成功");
            } else {
                System.out.println("消息发送确认失败:" + cause);
            }
        }
    }
}
