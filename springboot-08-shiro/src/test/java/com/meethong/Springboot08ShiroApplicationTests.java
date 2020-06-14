package com.meethong;

import com.meethong.service.UserserviceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot08ShiroApplicationTests {

    @Autowired
    UserserviceImpl userservice;
    @Test
    void contextLoads() {
       System.out.println(userservice.querUserByName("liaoh"));
    }

}
