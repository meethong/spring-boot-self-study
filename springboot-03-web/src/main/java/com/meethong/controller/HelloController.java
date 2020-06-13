package com.meethong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "index";
    }

    @GetMapping("/home")
    public String goHome(Map<String, Object> paramMap) {
        /** 默认Map的内容会放大请求域中，页面可以直接使用Thymeleaf取值*/
        paramMap.put("name", "张三");
        paramMap.put("age", 35);
        return "hello";
    }

}
