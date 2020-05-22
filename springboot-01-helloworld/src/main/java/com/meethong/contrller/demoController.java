package com.meethong.contrller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {

        @RequestMapping("/hello")
       public  String  test(){
           return "hello world";
       }
}
