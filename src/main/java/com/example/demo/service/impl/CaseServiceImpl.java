package com.example.demo.service.impl;

import com.example.demo.bean.Case;
import com.example.demo.bean.Task;
import com.example.demo.jdbc.CaseRowMapper;
import com.example.demo.jdbc.TaskRowMapper;
import com.example.demo.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {


    @Value("${dateformat}")
    String dateformat;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Case> findCasesbyTaskid(int id,int pageon) {

        int start = (pageon - 1) * 20;

        String sql= "select id,taskid,task_name,num,pirority,pirority_name,name,precondition,body,\n" +
                "assertion,passflag,casepassflag_name,memo,creationdt,updatedt from qa_case\n" +
                "join qa_task on task_id = taskid\n" +
                "join qa_pirority on pirority_id = pirority\n" +
                "join qa_casepassflag on casepassflag_id=passflag\n" +
                "where deleted_flag =0 and task_deleted_flag = 0\n" +
                "and taskid = ? ";

        String sql2 = sql + " order by 1 desc limit " + start + " , 20";
        //String sql2 = sql+" order by 1 desc offset  "+ start+  "  rows fetch next  20 rows only";

        List<Case> lists= jdbcTemplate.query(sql2,new CaseRowMapper(),id);
        return lists;
    }

    @Override
    public int countCasesbyTaskid(int id,int pageon) {

        String sql= "select id,taskid,task_name,num,pirority,pirority_name,name,precondition,body,\n" +
                "assertion,passflag,casepassflag_name,memo,creationdt,updatedt from qa_case\n" +
                "join qa_task on task_id = taskid\n" +
                "join qa_pirority on pirority_id = pirority\n" +
                "join qa_casepassflag on casepassflag_id=passflag\n" +
                "where deleted_flag =0 and task_deleted_flag = 0\n" +
                "and taskid = ? ";

        int count = jdbcTemplate.query(sql, new CaseRowMapper(), id).size();

        return count;
    }



    @Override
    public Case findById(int id) {

        String sql = "select id,taskid,task_name,num,pirority,pirority_name,name,precondition,body,assertion,passflag,casepassflag_name,memo,creationdt,updatedt\n" +
                "from qa_case join qa_task on task_id = taskid\n" +
                "join qa_pirority on pirority = pirority_id\n" +
                "join qa_casepassflag on passflag =casepassflag_id\n" +
                "where deleted_flag =0 and task_deleted_flag = 0\n" +
                "and id = ?";
        Case testcase = jdbcTemplate.queryForObject(sql, new CaseRowMapper(), id);
        return testcase;
    }

    @Override
    public int create(Case testcase) {

        String sql ="insert qa_case(taskid,num,pirority,name,precondition,body,assertion,passflag,creationdt,updatedt)\n" +
                "values(?,?,?,?,?,?,?,?,?,?) ";

        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        int taskid = testcase.gettaskid();
        int NUM =testcase.getnum();
        int PIRORITY =testcase.getpirority();
        String NAME =testcase.getname();
        String PRECONDITION =testcase.getprecondition();
        String BODY =testcase.getbody();
        String ASSERTION =testcase.getassertion();
        int PASSFLAG =testcase.getpass_flag();

        int count = jdbcTemplate.update(sql,taskid, NUM, PIRORITY, NAME, PRECONDITION, BODY, ASSERTION, PASSFLAG, date, date);
        return count;
    }

    @Override
    public int createList(List<Case> list) {
        return 0;
    }

    @Override
    public int update(Case testcase) {

        String sql = "update qa_case set  num = ?,pirority = ?, name = ?, precondition = ?,\n" +
                "body = ?, assertion = ?, passflag = ?, updatedt= ? where id= ?";

        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        int id = testcase.getid();
        int NUM =testcase.getnum();
        int PIRORITY =testcase.getpirority();
        String NAME =testcase.getname();
        String PRECONDITION =testcase.getprecondition();
        String BODY =testcase.getbody();
        String ASSERTION =testcase.getassertion();
        int PASSFLAG =testcase.getpass_flag();

        int count = jdbcTemplate.update(sql, NUM, PIRORITY, NAME, PRECONDITION, BODY, ASSERTION, PASSFLAG, date, id);
        return count;
    }

    @Override
    public int deleteByID(int id) {
        String sql = "update qa_case set  deleted_flag =1, deleted_comment = '页面逻辑删除', updatedt= ? where id= ?";
        Date dt = new Date();
        SimpleDateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);
        int count = jdbcTemplate.update(sql, date, id);
        return count;
    }
}
