package com.example.service.impl;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mapper.EmpMapper;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    // 注入EmpMapper
    @Autowired
    private EmpMapper empMapper;

    // 获取分页结果
    @Override
    public PageResult<Emp> getPage(Integer startPage, Integer pageSize, String name,Integer age, Integer gender, LocalDate begin, LocalDate end) {
//        int start = (page-1)*pageSize;
//        List<Emp> emps= empMapper.selectPage(start,pageSize);
//        long total = empMapper.count();
        //设置分页参数
        PageHelper.startPage(startPage,pageSize);
        List<Emp> emps = empMapper.selectPage(name,gender,begin,end);
        Page<Emp> pages= (Page<Emp>) emps;
        PageResult<Emp> pageResult = new PageResult<Emp>(pages.getTotal(),pages.getResult());//pages.total是查询到的数据量
        return pageResult;
    }
}
