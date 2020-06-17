package com.meethong.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledService {

    @Scheduled(cron = "10 29 9 * * ? ")
    public void hello(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("hello正在执行"+df.format(new Date()));
    }
}
