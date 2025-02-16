package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 分页查询
     *
     * @param page     页码 起始为0 遵循前闭后开
     * @param pageSize 每页记录数
     */
    @GetMapping("/students")
    public Result page(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "10") int pageSize,
                       String name,
                       Integer age,
                       Integer gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end
    ) {
        log.info("分页查询 {},{},{},{},{},{}",page,pageSize,name,age,gender,begin,end);
        PageResult<Emp> empPageResult = empService.getPage(page,pageSize,name,age,gender,begin,end);
        return Result.success(empPageResult);
    }
}