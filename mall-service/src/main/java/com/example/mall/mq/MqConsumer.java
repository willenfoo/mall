package com.example.mall.mq;

import com.example.mall.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author fuwei
 */
@Component
public class MqConsumer {

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "hello_wilenfoo", durable = "true"),
            exchange = @Exchange(value = RabbitMqConfig.DEFAULT_EXCHANGE, delayed = "true"), key = RabbitMqConfig.ORDER_ROUTING_KEY)})
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "hello_wilenfoo2", durable = "true"),
            exchange = @Exchange(value = RabbitMqConfig.DEFAULT_EXCHANGE, delayed = "true"), key = RabbitMqConfig.ORDER_ROUTING_KEY)})
    public void process2(String hello) {
        System.out.println("Receiver22222222  : " + hello);
    }

    @RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "hello_wilenfoo3", durable = "true"),
            exchange = @Exchange(value = RabbitMqConfig.DEFAULT_EXCHANGE, delayed = "true"), key = RabbitMqConfig.PAY_ROUTING_KEY)})
    public void process3(String hello) {
        System.out.println("Receiver333  : " + hello);
    }

}
