package com.example.controller;

import com.example.pojo.*;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
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
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询 {}", empQueryParam);
        PageResult<Emp> empPageResult = empService.getPage(empQueryParam);
        return Result.success(empPageResult);
    }

    @PostMapping("/students")
    public Result add(@RequestBody Emp emp) {
        log.info(emp.toString());
        empService.add(emp);
        return Result.success();
    }
    @DeleteMapping("/students")
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除部门: ids={} ", ids);
        empService.deleteByIds(ids);
        return Result.success();
    }
    @GetMapping("/students/{id}")
    public Result queryEmpAllInfoById(@PathVariable Integer id){
        Emp emp = empService.getEmpAllInfoById(id);
        return Result.success(emp);
    }

    @PutMapping("/students")
    public Result modifyEmpInfo(@RequestBody Emp emp){
        log.info(emp.toString());
        empService.saveEmpInfo(emp);
        return Result.success();
    }
}