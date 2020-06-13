package com.meethong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session,
                        Model model) {
        if (!StringUtils.isEmpty(username) && "1".equals(password)) {
            //登录成功！
            session.setAttribute("username", username);
            System.out.println("登陆成功=======>>>>" + session.getAttribute("username"));
            return "redirect:/main.html";
        } else {
            //登录失败！
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }

    public String loginOut(HttpSession session) {
        session.invalidate();
        return "redirect:main";
    }
}

