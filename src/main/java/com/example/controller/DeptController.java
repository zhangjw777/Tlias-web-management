package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DeptService deptService;


    /*查询部门列表*/
    @GetMapping("/depts")
    public Result list() {
        return Result.success(deptService.findALl());
    }

    @DeleteMapping("/depts")
//    前端post请求参数名与这里的形参变量名要保持相同，否则接受不到，前端写得是id，这里形参也得写id
    public Result deleteById(int id) {
        deptService.deleteById(id);
        return Result.success();
    }

    /*前端post请求是一个json对象，则使用@RequestBody注解标识
    内容例如：{"name":"研发部"}。这里，我们可以通过一个实体对象来接收，只需要保证对象中有name属性即可。*/
    @PostMapping("/depts")
    public Result addDept(@RequestBody Dept dept){
        deptService.addDept(dept);
        return Result.success();
    }
}
