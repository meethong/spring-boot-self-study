package com.meethong.controller;


import com.meethong.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello(){
        System.out.println(new Date());
        asyncService.hello();
        System.out.println(new Date());
        return "ok";

    }
}
