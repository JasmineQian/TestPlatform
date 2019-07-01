package com.example.demo.controller;


import com.example.demo.email.BugNotify;
import com.example.demo.email.BugNotifyBean;
import com.example.demo.email.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class MailScheduler {

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

    @Scheduled(cron = "0 0/15 * * * ?")   //每15分钟触发一次
    //@Scheduled(cron = "5/10 * * * * ?") //第5秒钟触发，每10秒中触发一次
    //@Scheduled(cron = "0 0/2 * * * ?") //第0分钟触发，每2分钟中触发一次
    public void doTask() {
        System.out.println("执行了MyStaticTask,时间为:" + new Date(System.currentTimeMillis()));
        logger.error("我要开始发邮件啦,现在的时间为:" + new Date(System.currentTimeMillis()));
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

            String img = "c:\\logo\\"+bugNotifyBean.getImg();
            String emailContent = templateEngine.process("emailTemplate", context);
            mailService.sendHtmlMail(developerEmail, testerEmail,"您好，有一个Bug要关注，谢谢!!", emailContent,img);

        }

    }
}
