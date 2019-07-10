package com.example.mall;

import com.baomidou.mybatisplus.dts.EnableDtsRabbit;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author fuwei
 * 项目启动类
 */
@SpringBootApplication
@EnableDtsRabbit
@EnableEurekaClient
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class MallServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(MallServiceApp.class, args);
    }

}
