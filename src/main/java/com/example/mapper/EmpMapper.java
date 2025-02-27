package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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


    List<Emp> selectPage(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id") //主键返回，在插入后会将数据库主键自增的的值返回给Emp实体类
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);


    Emp selectAllInfoById(Integer id);

    void update(Emp emp);

    @MapKey("job")
    List<Map<String,Integer>> countEmpJobData();
}
