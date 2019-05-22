package com.example.demo.email;

public interface MailService {

    void sendSimpleMail(String to, String subject, String content);

    void sendHtmlMail(String to, String cc,String subject, String content);

    void sendAttachmentsMail(String to, String subject, String content, String filePath);

}
