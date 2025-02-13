package com.example.mapper;

import com.example.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select * from dept")
    List<Dept> findAll();

    @Delete("delete from dept where id =#{deptId}")
    void deleteById(int deptId);

    //不需要显示的把dept的属性.(点)出来，#{}会自动把对象里的属性提出来，并且我们还开启了驼峰下划线映射，表名也不用再映射
//    注意：#{...} 里面写的是对象的属性名【注意是属性名，不是表的字段名】
    @Insert("insert into dept(name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);
}
