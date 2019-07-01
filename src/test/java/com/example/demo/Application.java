package com.example.demo;


import com.example.demo.email.BugNotify;
import com.example.demo.email.BugNotifyBean;
import com.example.demo.email.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Application {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BugNotify bugNotify;

    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void doTask() {
        System.out.println("执行了MyStaticTask,时间为:" + new Date(System.currentTimeMillis()));

        List<BugNotifyBean> lists = bugNotify.BugNotify();

        Iterator it = lists.iterator();
        while (it.hasNext()) {

            BugNotifyBean bugNotifyBean = (BugNotifyBean) it.next();
            String developerEmail = bugNotifyBean.getDeveloperEmail();
            String testerEmail = bugNotifyBean.getTesterEmail();
            Context context = new Context();
            context.setVariable("bugnum", "bugnum#"+bugNotifyBean.getId());
            context.setVariable("bugdes", bugNotifyBean.getDescription());
            context.setVariable("bugstatus", bugNotifyBean.getBugStatus());
            context.setVariable("crname", bugNotifyBean.getCrname());
            context.setVariable("crnum", bugNotifyBean.getCrnum());
            context.setVariable("oname", bugNotifyBean.getOname());
            context.setVariable("pname", bugNotifyBean.getPname());
            context.setVariable("rca", bugNotifyBean.getRca());
            context.setVariable("tasknum", bugNotifyBean.getTasknum());
            context.setVariable("solution", bugNotifyBean.getSolution());

            String img = "src/main/resources/static/image/"+bugNotifyBean.getImg();
            String emailContent = templateEngine.process("emailTemplate", context);
            mailService.sendHtmlMail(developerEmail, testerEmail,"您好，有一个Bug要关注，谢谢!!", emailContent,img);

        }

    }
}















