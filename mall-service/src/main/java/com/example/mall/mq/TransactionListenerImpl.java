package com.example.mall.mq;

import com.baomidou.mybatisplus.dts.DtsMeta;
import com.baomidou.mybatisplus.dts.listener.IDtsListener;
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
public class TransactionListenerImpl implements IDtsListener {

    public static final Logger logger = LoggerFactory.getLogger(TransactionListenerImpl.class);

    @Override
    public void process(DtsMeta dtsMeta) {
        logger.info("分布式事务监听处理, dtsMeta:{}", dtsMeta);

        /**
         * 根据 event 处理不同业务逻辑
         */
        if (dtsMeta.getEvent().startsWith("Error")) {
            throw new RuntimeException("Test receiver exception");
        }
    }
}
