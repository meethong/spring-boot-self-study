package com.meethong.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Service
@Component //使用是dubbo尽量不用service注册 不好区分
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "我的ticket";
    }

    @Override
    public String hello(String message) {
        return "hello," + message;
    }
}
