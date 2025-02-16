package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {
    //总记录数
    private Long total;
    //当前页数据列表 也就是传给前端的记录s 我认为这里取名应该叫Records,但是名字不能乱改，也严格按照接口文档对应前端来，否则前端解析名称失败
    private List<T> rows;
}