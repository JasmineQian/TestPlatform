package com.example.demo.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
//@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.bcc}")
    private String bcc;

    @Override
    public void sendHtmlMail(String to, String cc,String subject, String content,String img) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);//邮件接收者
            helper.setCc(cc);
            helper.setBcc(bcc);
            helper.setSubject(subject);//邮件主题
            helper.setText(content, true);//邮件内容

            String imagePath = img;
            FileSystemResource avatar = new FileSystemResource(imagePath);
            System.out.println(avatar);
            helper.addInline("avatar",avatar);

            javaMailSender.send(message);
            logger.info("发送HTML邮件成功！");
        } catch (MessagingException e) {
            logger.error("发送HTML邮件时发生异常！", e);
        }
    }


}
