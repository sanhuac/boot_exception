package com.hc.boot_exception_email.controller;

import com.hc.boot_exception_email.exception.MyException;
import com.hc.boot_exception_email.model.User;
import com.hc.boot_exception_email.util.Code;
import com.hc.boot_exception_email.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.javamail.JavaMailSender;


/**
 * @Author hucong
 * @Description //TODO $
 * @Date $ $
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping(value = "/add")
    Response<User> add(@Validated User user){

        //todo 此处为模拟返回
        Response<User> response = new Response<>();
        response.setCode(Code.SUCCESSED);
        response.setResult(new User());
        return  response;
    }


    @PostMapping(value = "/update")
    Response<Boolean> update(User user){

        //todo 此处为模拟异常抛出
        if(true){
            throw new MyException("更新失败");
        }
        //todo 此处为模拟返回
        Response<Boolean> response = new Response<>();
        response.setCode(Code.SUCCESSED);
        response.setResult(true);
        return  response;
    }

    @PostMapping(value = "/sendEmail")
    Response<Boolean> sendEmail(){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("916714732@qq.com");//发送者
        message.setTo("hucong@tongniutech.com");//接收者
        message.setSubject("测试主题");//邮件主题
        message.setText("测试内容");//邮件内容
        javaMailSender.send(message);
        Response<Boolean> response = new Response<>();
        response.setCode(Code.SUCCESSED);
        response.setResult(true);
        return  response;
    }
}
