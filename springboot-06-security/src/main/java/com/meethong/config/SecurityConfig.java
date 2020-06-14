package com.meethong.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//AOP
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问,功能页只有对应有权限的人才能访问
        http.authorizeRequests()
                      .antMatchers("/").permitAll()
                      .antMatchers("/level1/***").hasRole("vip1")
                      .antMatchers("/level2/***").hasRole("vip2")
                      .antMatchers("/level3/***").hasRole("vip3");
        //没有权限到login页面
        http.formLogin()//默认登录页面
        .loginPage("/toLogin")
        .usernameParameter("username")
        .passwordParameter("password")
        .loginProcessingUrl("/login");
        http.csrf().disable(); //跨域请求
        http.logout().logoutSuccessUrl("/"); //注销后跳转/
        http.rememberMe().rememberMeParameter("remember"); //session
    }
    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                  .withUser("vip1").password(new BCryptPasswordEncoder().encode("123")).roles("vip1")
                  .and()
                  .withUser("vip2").password(new BCryptPasswordEncoder().encode("123")).roles("vip2")
                  .and()
                  .withUser("vip3").password(new BCryptPasswordEncoder().encode("123")).roles("vip3")
                  .and()
                  .withUser("liaoh").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2","vip3");
    }
}
