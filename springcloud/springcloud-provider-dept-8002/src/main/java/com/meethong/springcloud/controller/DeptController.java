package com.meethong.springcloud.controller;

import com.meethong.pojo.Dept;
import com.meethong.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return  deptService.addDept(dept);
    }
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return  deptService.queryById(id);
    }
    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return  deptService.queryAll();
    }

    //注册进来的微服务 获取消息
    @GetMapping("/dept/discovery")
    public  Object discovery(){
        //获取微服务列表的清单
        List<String> service=client.getServices();
        System.out.println("discovery===>"+service);

        //得到一个具体的微服务信息
        List<ServiceInstance> instances=client.getInstances("TEST");
        for (ServiceInstance instance : instances){
            System.out.println(
                          instance.getHost()+"\t"+
                          instance.getPort()+"\t"+
                          instance.getUri()+"\t"+
                          instance.getServiceId()
            );
        }
        return this.client;
    }
}
