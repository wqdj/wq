package com.lanou.newtest.mapper;

import com.lanou.newtest.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmpMapper {
    //新增员工
    public int EmpAdd(Emp emp);
}
