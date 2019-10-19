package com.lanou.newtest.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.newtest.bean.Emp;
import com.lanou.newtest.info.SendSms;
import com.lanou.newtest.service.EmpMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpMapperService empMapperService;

    @RequestMapping("empadd")
    @ResponseBody
    public String EmpAdd(Emp emp, HttpServletRequest request) throws Exception{
        String msg = "";
        request.setCharacterEncoding("utf-8");
        String account = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("root");
       // System.out.println(jedis.ping());
        //int rr = jedis.get("sms");
        //String code = String.valueOf(111);
        String code = jedis.get("sms");
        int departmentid = Integer.parseInt(request.getParameter("depart"));
        List<Emp> emps = empMapperService.empAll();
        //System.out.println(emps);
        boolean isAgain = true;
        for (Emp emp1 : emps){
            if (emp1 != null && emp1.getAccount() != null && emp1.getAccount().equals(account)){
                isAgain = false;
            }
        }
        if (isAgain){
        if (pwd != null && pwd.equals(code)){
            Random random = new Random();
            String password = String.valueOf(random.nextInt(9000)+1000);
            emp.setAccount(account);
            emp.setPassword(password);
            emp.setDepartmentid(departmentid);

            int row = empMapperService.EmpAdd(emp);
            if(row > 0){
                msg = "注册成功";
            }else {
                msg = "注册失败";
            }
        }else {
            msg = "验证码不相符!注册失败";
        }
        }else {
            msg = "该手机号已注册!注册失败!请重新注册!";
        }
        return JSON.toJSONString(msg);
    }
    @RequestMapping("send")
    @ResponseBody
    public String send1(HttpServletRequest request){
        String phone = request.getParameter("phone");
        //SendSms.send();
        SendSms.main(phone);
        return JSON.toJSONString("验证码已发送");
    }

}
