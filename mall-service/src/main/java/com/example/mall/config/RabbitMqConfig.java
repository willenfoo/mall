package com.example.mall.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author fuwei
 */
@Configuration
public class RabbitMqConfig {

    public static final String DEFAULT_EXCHANGE = "default_exchange";

    /**
     * 下单完成的路由key
     */
    public static final String ORDER_ROUTING_KEY = "order_routing_key";

    /**
     * 支付完成的路由key
     */
    public static final String PAY_ROUTING_KEY = "pay_routing_key";



}
