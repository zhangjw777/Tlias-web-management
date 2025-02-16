package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /**
     * 分页查询(传统方法)
     *
     * @param start 页码 起始为0 遵循前闭后开
     * @param end   每页记录数
     */
//    @Select("select * from emp left join dept on emp.dept_id = dept.id limit #{start},#{end}")
//    List<Emp> selectPage(int start, int end);
//
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id ")
//    public Long count();


    List<Emp> selectPage(String name, Integer gender, LocalDate begin, LocalDate end);
}
