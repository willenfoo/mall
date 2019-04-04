package com.example.mall.task;

import com.example.mall.common.RedisKeyManage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 定时器
 * @author fuwei
 */
@Component
@Slf4j
public class ScheduledTask {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 定时器拉取充值记录
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void pullRechargeRecord() {
        String lockTaskRedisKey = RedisKeyManage.generate(RedisKeyManage.TASK_LOCK_DOME);
        long count = 0;
        ValueOperations<String, String> valueOps = stringRedisTemplate.opsForValue();
        try {
            count = valueOps.increment(lockTaskRedisKey, 1);
            if (count == 1) {
                stringRedisTemplate.expire(lockTaskRedisKey, 60 * 60, TimeUnit.SECONDS);
                log.info("定时器, 拉取充值记录, 开始");

                log.info("定时器, 拉取充值记录, 结束");
            }
        } finally {
            if (count == 1) {
                //休眠30秒，在分布式下，每台机器相差几秒钟，如果定时器执行很短，会重复执行
                sleep();
                stringRedisTemplate.delete(lockTaskRedisKey);
            }
        }
    }

    /**
     * 休眠30秒，在分布式下，每台机器相差几秒钟，如果定时器执行很短，会重复执行
     */
    private void sleep() {
        try {
            Thread.sleep(1000 * 30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

