package com.example.demo.email;

public interface MailService {

    void sendHtmlMail(String to, String cc,String subject, String content,String img);

}
