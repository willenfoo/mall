package com.example.mall.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuwei
 */
@Configuration
public class RabbitMqConfig implements RabbitTemplate.ConfirmCallback {

    public RabbitMqConfig(RabbitTemplate rabbitTemplate) {
        rabbitTemplate.setConfirmCallback(this);
    }

    public static final String DEFAULT_EXCHANGE = "default_exchange";

    /**
     * 下单完成的路由key
     */
    public static final String ORDER_ROUTING_KEY = "order_routing_key";

    /**
     * 支付完成的路由key
     */
    public static final String PAY_ROUTING_KEY = "pay_routing_key";

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println(" rabbitTemplate confirm");
    }
}
