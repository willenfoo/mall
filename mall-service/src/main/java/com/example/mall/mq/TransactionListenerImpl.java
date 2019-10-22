package com.example.mall.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * rabbitmq 分布式事务监听处理
 *
 * @author fwuei
 * @since 2019-04-21
 */
@Component
public class TransactionListenerImpl  {

    public static final Logger logger = LoggerFactory.getLogger(TransactionListenerImpl.class);

}
