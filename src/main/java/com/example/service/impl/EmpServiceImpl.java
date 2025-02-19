package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpExpr;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mapper.EmpMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    // 注入EmpMapper
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

    // 获取分页结果
    @Override
    public PageResult<Emp> getPage(EmpQueryParam empQueryParam) {
//        int start = (page-1)*pageSize;
//        List<Emp> emps= empMapper.selectPage(start,pageSize);
//        long total = empMapper.count();
        //设置分页参数
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> emps = empMapper.selectPage(empQueryParam);
        Page<Emp> pages= (Page<Emp>) emps;
        PageResult<Emp> pageResult = new PageResult<Emp>(pages.getTotal(),pages.getResult());//pages.total是查询到的数据量
        return pageResult;
    }

    /**
     *
     * 注解：@Transactional
     * 作用：就是在当前这个方法执行开始之前来开启事务，方法执行完毕之后提交事务。如果在这个方法执行的过程当中出现了异常，就会进行事务的回滚操作。
     * 位置：业务层的方法上、类上、接口上
     *   - 方法上：当前方法交给spring进行事务管理
     *   - 类上：当前类中所有的方法都交由spring进行事务管理
     *   - 接口上：接口下所有的实现类当中所有的方法都交给spring 进行事务管理
     *   默认情况下，只有出现RuntimeException(运行时异常)才会回滚事务。
     *   假如我们想让所有的异常都回滚，需要来配置@Transactional注解当中的rollbackFor属性，通过rollbackFor这个属性可以指定出现何种异常类型回滚事务。
     *   另外还有事务传播，篇幅有限，可见云文档day-9
     */

    @Override
    @Transactional
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        log.info("新增员工 {}", emp);
        empMapper.insert(emp);
        Integer empId = emp.getId();
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList))
            exprList.forEach(expr->{
                expr.setEmpId(empId);
                empExprMapper.addExpr(expr);
            });

    }
}
