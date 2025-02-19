package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpExpr;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;

import java.util.List;

public interface EmpService {
    PageResult<Emp> getPage(EmpQueryParam empQueryParam);

    void add(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getEmpAllInfoById(Integer id);

    void saveEmpInfo(Emp emp);
}
