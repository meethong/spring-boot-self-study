package com.meethong;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    void contextLoads() {
        //一个简单的邮件~
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("Springboot--->测试发信2222222");
        mailMessage.setText("——————————>信件内容22222");
        mailMessage.setFrom("66@ops.com");
        mailMessage.setTo("66@ops.com");
        mailSender.send(mailMessage);
    }

    void contextLoads2()  throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage=mailSender.createMimeMessage();
       //组装
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        //正文
        helper.setSubject("SringBoot-复杂邮件");
        helper.setText("<p style='color:red'>——————————>信件内容</p>");
        //附件
        helper.addAttachment("4.sql",new File("D:\\UAP4.sql"));
        helper.setTo("66@ops.com");
        helper.setFrom("66@ops.com");
        mailSender.send(mimeMessage);
        System.out.println("发送成功----->内容为"+mimeMessage);
    }

}
