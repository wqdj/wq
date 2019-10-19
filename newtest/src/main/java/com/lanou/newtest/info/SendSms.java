package com.lanou.newtest.info;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import redis.clients.jedis.Jedis;

import java.util.Random;

public class SendSms {
    public static void main(String phone) {
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fsuiqa9Qfcuk1AfPWDX", "BZ2Y7XKbcaImqVGzLxEYkfVSXvUnWj");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "惘勤");
        request.putQueryParameter("TemplateCode", "SMS_175572092");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+send()+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
    public static int send(){
        Random random = new Random();
        int code1 = random.nextInt(90000)+10000;
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.auth("root");
        //System.out.println(jedis.ping());
        jedis.set("sms",String.valueOf(code1));
        jedis.expire("sms",180000);
            return code1;
    }
}
