package com.lanou.newtest.mapper;

import com.lanou.newtest.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmpMapper {
    //新增员工
    public int EmpAdd(Emp emp);

    //判断手机号是否存在
    public Emp selectByPhone(String phone);

    //账号密码登录查询
    public Emp selectByPwd(@Param("phone") String phone, @Param("password") String password);

}
