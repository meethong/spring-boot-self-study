package com.meethong.springcloud.service;

import com.meethong.pojo.Dept;

import java.util.List;


public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryById(Long id);
    public List<Dept> queryAll();

}
