package com.example.demo;


import com.example.demo.email.BugNotifyBean;
import com.example.demo.email.BugNotifyRowMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass =passwordEncoder.encode("1qaz2wsx");
        System.out.println(pass);
    }

    @Value("${dateformat}")
    String dateformat;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void BugNotify() {

        Calendar nowBefore = Calendar.getInstance();
        Calendar nowAfter = Calendar.getInstance();
        nowBefore.add(Calendar.MINUTE, 15);
        nowAfter.add(Calendar.MINUTE, -15);
        SimpleDateFormat sdf= new SimpleDateFormat(dateformat);
        String date =sdf.format(nowAfter.getTimeInMillis());

        System.out.println(date);

        String sql = "select bug_id,project_name,cr_name,bug_cr_num,bug_task_num,object_name,bug_description,bug_rca,bug_solution,b.employ_email developer,a.employ_email tester,qa_creationdt,qa_updatedt,STATUS_DES\n" +
                "from qa_buglist\n" +
                "join qa_project on bug_project_id = project_id  \n" +
                "join qa_crtype on cr_id = bug_cr_type_id  \n" +
                "join qa_rtype on object_id = qa_type_id  \n" +
                "join qa_employ a on a.employ_id = qa_tester_id and a.employ_group = 1   \n" +
                "join qa_employ b on b.employ_id= qa_assignee_id and b.employ_group = 2  \n" +
                "join qa_bugstatus on status_id =  bug_status_id\n" +
                "where bug_deleted_flag =0 \n" +
                "and qa_updatedt > ?";


        List<BugNotifyBean> lists =jdbcTemplate.query(sql,new BugNotifyRowMapper(),date);
        System.out.println(lists);
    }
}














