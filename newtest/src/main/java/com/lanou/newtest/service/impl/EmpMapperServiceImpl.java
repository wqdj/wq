package com.lanou.newtest.service.impl;

import com.lanou.newtest.bean.Emp;
import com.lanou.newtest.mapper.EmpMapper;
import com.lanou.newtest.service.EmpMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpMapperServiceImpl implements EmpMapperService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public int EmpAdd(Emp emp) {
        return empMapper.EmpAdd(emp);
    }

    @Override
    public Emp selectByPhone(String phone) {
        return empMapper.selectByPhone(phone);
    }

    @Override
    public Emp selectByPwd(String phone, String password) {
        return empMapper.selectByPwd(phone,password);
    }
}
