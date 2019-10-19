package com.lanou.newtest.service;

import com.lanou.newtest.bean.Emp;

import java.util.List;

public interface EmpMapperService {
    //新增员工
    public int EmpAdd(Emp emp);

    //验证码登录判断
    public Emp selectByPhone(String phone);

    //账号登录判断
    public Emp selectByPwd(String phone,String password);

}
