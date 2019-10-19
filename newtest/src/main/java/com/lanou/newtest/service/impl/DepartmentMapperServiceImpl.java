package com.lanou.newtest.service.impl;

import com.lanou.newtest.bean.Department;
import com.lanou.newtest.mapper.DepartmentMapper;
import com.lanou.newtest.service.DepartmentMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentMapperServiceImpl implements DepartmentMapperService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> departmentAll() {
        return departmentMapper.departmentAll();
    }
}
