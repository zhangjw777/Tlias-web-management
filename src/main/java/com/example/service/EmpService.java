package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> getPage(Integer page, Integer pageSize, String name,Integer age, Integer gender, LocalDate begin, LocalDate end);
}
