package com.example.demo.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步执行
 */
@Component
public class AsyncUtil {

    @Value("${spring.mail.username}")
    private String Sender;

    @Autowired
    private JavaMailSender mailSender;

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncUtil.class);

    @Async
    public void sendEmail(String email) {

        LOGGER.info("send email to {} ...", email);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(Sender);
        message.setTo(email);
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
        LOGGER.info("send email to {} success", email);
    }

}

