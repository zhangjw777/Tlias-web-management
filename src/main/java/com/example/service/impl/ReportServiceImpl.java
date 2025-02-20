package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.JobOption;
import com.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Slf4j
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String,Integer>> Job_Countlist = empMapper.countEmpJobData();
        List<String> jobList = Job_Countlist.stream().map(dataMap -> String.valueOf(dataMap.get("job"))).toList();
        List<String> dataList = Job_Countlist.stream().map(dataMap -> String.valueOf(dataMap.get("total"))).toList();
        return new JobOption(jobList,dataList);
    }
}
