package com.example.mall.task;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 * @author fuwei
 */
@Component
@Slf4j
public class ScheduledTask {

    /**
     * 定时器拉取充值记录的锁
     */
    private final static String TASK_LOCK_PULL_RECHARGE_RECORD = "task:lock:pullRechargeRecord";

    /**
     * 定时器拉取充值记录
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    @SchedulerLock(name = TASK_LOCK_PULL_RECHARGE_RECORD)
    public void pullRechargeRecord() {
        log.info("定时器, 拉取充值记录, 开始");
        try {

        } catch (Exception e){
            log.error("定时器, 拉取充值记录, 出现异常", e);
        }
        log.info("定时器, 拉取充值记录, 结束");
    }



}

