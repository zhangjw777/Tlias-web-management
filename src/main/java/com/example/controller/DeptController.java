package com.example.controller;

import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DeptService deptService;


    /*查询部门列表*/
    @RequestMapping("/dept")
    public List<Dept> list(){
        return deptService.findALl();
    }
}
