package com.ergou.user.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class publishTask {

    @Scheduled(cron = "0/3 * * * * ?")
    private void publish() {
        System.out.println("定时任务执行：" + LocalDateTime.now());
    }
}