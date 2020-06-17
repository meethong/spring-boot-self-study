package com.meethong.swagger.controller;


import com.meethong.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
public class HelloController {
    @GetMapping("/")
    public String hello(){
        return "hello";
    }

    //只要返回值存在实体类 会自动被扫描到swagger中
    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @ApiOperation("用户方法")
    @GetMapping("/test")
    public String test(@ApiParam("用户名") String username){

        System.out.println(username);
        return  "hello"+username;
    }
    @ApiOperation("Post测试")
    @PostMapping("/postca")
    public  User test2(@RequestParam("username") String username,
                      @RequestParam("password") String password){
      User user=new User();
      user.setUsername(username);
      user.setPassword(password);
      return  user;
    }
}
