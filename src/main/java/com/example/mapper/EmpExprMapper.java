package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpExprMapper {

    void addExpr(EmpExpr expr);
}
