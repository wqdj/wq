package com.lanou.newtest.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.newtest.bean.Department;
import com.lanou.newtest.info.SendSms;
import com.lanou.newtest.service.DepartmentMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("depart")
public class DepartmentController {
    @Autowired
    private DepartmentMapperService departmentMapperService;
    @RequestMapping("findAll")
    @ResponseBody
    public String departmentAll(){
        List<Department> departmentList = departmentMapperService.departmentAll();
        return JSON.toJSONString(departmentList);
    }
}
