package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void insertExpr(EmpExpr expr);

    void deleteExprsByEmpIds(List<Integer> empIds);
}
