package com.ergou.utils;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import com.ergou.utils.extend.AliyunResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSUtils {

    @Autowired
    private AliyunResource aliyunResource;

    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public void sendSMS(String phoneNumber, String code) throws Exception {
        Client client = SMSUtils.createClient(aliyunResource.getAccessKeyId(), aliyunResource.getAccessKeySecret());
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phoneNumber)
                .setSignName("风简约赢")
                .setTemplateCode("234")
                .setTemplateParam(code);        // 复制代码运行请自行打印 API 的返回值
        client.sendSms(sendSmsRequest);
    }
}
