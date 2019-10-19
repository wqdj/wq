package com.lanou.newtest.service;

import com.lanou.newtest.bean.Emp;

import java.util.List;

public interface EmpMapperService {
    //新增员工
    public int EmpAdd(Emp emp);
    //查询所有员工
    public List<Emp> empAll();
}
