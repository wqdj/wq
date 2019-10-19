package com.lanou.newtest.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.newtest.bean.Emp;
import com.lanou.newtest.service.EmpMapperService;
import com.lanou.newtest.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("emp")
public class EmpController {

    @Autowired
    EmpMapperService empMapperService;

    @RequestMapping("loginCode")
    public String loginCode(String phone){
        if (phone != null && !phone.equals("")){
            String code = String.valueOf((int)(Math.random()*9000)+1000);
            SendSms.SendCode(phone,code);
            Jedis jedis = new Jedis("127.0.0.1",6379);
            jedis.set("code",code);
            jedis.expire("code",300);
            return JSON.toJSONString(1);
        }else {
            return JSON.toJSONString(2);
        }
    }

    @RequestMapping("phoneLogin")
    public String phoneLogin(String phone1,String password,String phone,String code){
        if (phone1 != null && !phone1.equals("") && password != null && !password.equals("")){
            Emp emp = empMapperService.selectByPwd(phone1,password);
            if (emp != null){
                return JSON.toJSONString(1);
            }else {
                return JSON.toJSONString(2);
            }
        }else if (phone != null && !phone.equals("") && code != null && !code.equals("")) {
            Jedis jedis = new Jedis("127.0.0.1",6379);
            String code2 = jedis.get("code");
            if(code2 == null){
                return JSON.toJSONString(7);
            }
            if (code.equals(code2)){
                Emp emp = empMapperService.selectByPhone(phone);
                if (emp !=null){
                    return JSON.toJSONString(4);
                }else {
                    return JSON.toJSONString(5);
                }
            }else {
                return JSON.toJSONString(3);
            }
        }else {
            return JSON.toJSONString(6);
        }
    }


}
