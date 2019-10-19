package com.lanou.newtest.mapper;

import com.lanou.newtest.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmpMapper {
    //新增员工
    public int EmpAdd(Emp emp);

    //根据手机号查询员工信息
    public Emp selectByPhone(String phone);

}
