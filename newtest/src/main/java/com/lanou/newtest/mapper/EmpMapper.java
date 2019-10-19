package com.lanou.newtest.mapper;

import com.lanou.newtest.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmpMapper {
    //新增员工
    public int EmpAdd(Emp emp);
    //查询所有员工
    public List<Emp> empAll();
}
