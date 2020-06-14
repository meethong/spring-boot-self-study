package com.meethong.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class indexController {

    @RequestMapping({"/","/index"})
    public  String index(){
        return "index";
    }
    @RequestMapping("/user/add")
    public  String add(){
        return "/user/add";
    }
    @RequestMapping("/user/update")
    public  String update(){
        return "/user/update";
    }

    @RequestMapping("/login")
    public  String login(){
        return "login";
    }
    @RequestMapping("/acces")
    public  String acces(String username, String password, Model model){
        //获取当前的用户
        Subject subject= SecurityUtils.getSubject();
        System.out.println(subject);
        //封装用户的登陆数据
        UsernamePasswordToken token =new UsernamePasswordToken(username,password);
        System.out.println(token);
        try{
            subject.login(token);
            return "index";
        }catch (UnknownAccountException uae) {
            model.addAttribute("msg","用户名错误");
            System.out.println("用户名错误");
            return "login";
        } catch (IncorrectCredentialsException ice) {
            model.addAttribute("msg","密码错误");
            System.out.println("密码错误");
            return "login";
        } catch (LockedAccountException lae) {
            System.out.println("The account for username " + token.getPrincipal() + " is locked.  " +
                          "Please contact your administrator to unlock it.");
        }
        // ... catch more exceptions here (maybe custom ones specific to your application?
        catch (AuthenticationException ae) {
            return "login";
        }
        return "index";
    }
    @ResponseBody
    @RequestMapping("/nologin")
    public  String nologin(){
        return "权限不足";
    }
}
