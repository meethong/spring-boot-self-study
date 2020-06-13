package com.meethong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public List<Map<String,Object>> jdbc(){
     String sql="select * from admin_info";
     List<Map<String,Object>> maps=jdbcTemplate.queryForList(sql);
     return maps;
    }

}
