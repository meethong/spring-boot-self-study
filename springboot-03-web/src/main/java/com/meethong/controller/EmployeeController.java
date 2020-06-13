package com.meethong.controller;

import com.meethong.dao.DepartmentDao;
import com.meethong.dao.EmployeeDao;
import com.meethong.pojo.Department;
import com.meethong.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //查询所有用户，返回列表页面
    @GetMapping("/emplist")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        //将结果放在请求中
        model.addAttribute("emps", employees);
        return "emp/list.html";
    }

    @GetMapping("/add")
    public String toAdd(Model model) {
        //查出所有的部门 提供选择
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "/add.html";
    }
}
