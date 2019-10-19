package com.lanou.newtest.mapper;

import com.lanou.newtest.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DepartmentMapper {
    //查询所有的部门
    public List<Department> departmentAll();
}
