package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findALl();

    void deleteById(int deptId);

    void addDept(Dept dept);
}
