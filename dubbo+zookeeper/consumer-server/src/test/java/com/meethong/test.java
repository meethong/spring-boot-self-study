package com.meethong;

import com.meethong.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class test {

    @Autowired
    TicketService userService;

    @Test
    void contextLoads() {
        System.out.println(userService.hello("1"));
    }

}
