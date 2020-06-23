package com.meethong.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.meethong.service.TicketService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
 /*   @Autowired
    private UserService helloService;*/
 @Reference
 private TicketService helloService;
    @GetMapping("/hello/{message}")
    public String hello(@PathVariable String message) {
        return helloService.hello(message);
    }

}
