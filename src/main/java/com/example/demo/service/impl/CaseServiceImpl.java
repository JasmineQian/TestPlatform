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

        String sql= "select case_id,case_taskid,task_name,case_num,case_pirority,pirority_name,case_name,case_precondition,case_body,\n" +
                "case_assertion,case_passflag,casepassflag_name,case_memo,case_creationdt,case_updatedt \n" +
                "from qa_case\n" +
                "join qa_task on task_id = case_taskid\n" +
                "join qa_pirority on pirority_id = case_pirority\n" +
                "join qa_casepassflag on casepassflag_id=case_passflag\n" +
                "where case_deleted_flag =0 and task_deleted_flag = 0\n" +
                "and case_taskid = ? ";

        String sql2 = sql + " order by 1 desc limit " + start + " , 20";
        //String sql2 = sql+" order by 1 desc offset  "+ start+  "  rows fetch next  20 rows only";

        List<Case> lists= jdbcTemplate.query(sql2,new CaseRowMapper(),id);
        return lists;
    }

    @Override
    public int countCasesbyTaskid(int id,int pageon) {

        String sql= "select case_id,case_taskid,task_name,case_num,case_pirority,pirority_name,case_name,case_precondition,case_body,\n" +
                "case_assertion,case_passflag,casepassflag_name,case_memo,case_creationdt,case_updatedt \n" +
                "from qa_case\n" +
                "join qa_task on task_id = case_taskid\n" +
                "join qa_pirority on pirority_id = case_pirority\n" +
                "join qa_casepassflag on casepassflag_id=case_passflag\n" +
                "where case_deleted_flag =0 and task_deleted_flag = 0\n" +
                "and case_taskid = ? ";

        int count = jdbcTemplate.query(sql, new CaseRowMapper(), id).size();

        return count;
    }



    @Override
    public Case findById(int id) {

        String sql = "select case_id,case_taskid,task_name,case_num,case_pirority,pirority_name,case_name,case_precondition,case_body,\n" +
                "case_assertion,case_passflag,casepassflag_name,case_memo,case_creationdt,case_updatedt \n" +
                "from qa_case\n" +
                "join qa_task on task_id = case_taskid\n" +
                "join qa_pirority on pirority_id = case_pirority\n" +
                "join qa_casepassflag on casepassflag_id=case_passflag\n" +
                "where case_deleted_flag =0 and task_deleted_flag = 0\n" +
                "and case_id = ? ";
        Case testcase = jdbcTemplate.queryForObject(sql, new CaseRowMapper(), id);
        return testcase;
    }

    @Override
    public int create(Case testcase) {

        String sql ="insert qa_case(case_taskid,case_num,case_pirority,case_name,case_precondition,case_body,case_assertion,case_passflag,case_creationdt,case_updatedt)\n" +
                "values(?,?,?,?,?,?,?,?,?,?) ";

        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        int taskid = testcase.getTaskid();
        int NUM =testcase.getNum();
        int PIRORITY =testcase.getPirority();
        String NAME =testcase.getName();
        String PRECONDITION =testcase.getPrecondition();
        String BODY =testcase.getBody();
        String ASSERTION =testcase.getAssertion();
        int PASSFLAG =testcase.getPass_flag();

        int count = jdbcTemplate.update(sql,taskid, NUM, PIRORITY, NAME, PRECONDITION, BODY, ASSERTION, PASSFLAG, date, date);
        return count;
    }

    @Override
    public int createList(List<Case> list) {
        return 0;
    }

    @Override
    public int update(Case testcase) {

        String sql = "update qa_case set  case_num = ?,case_pirority = ?, case_name = ?, case_precondition = ?,\n" +
                "case_body = ?, case_assertion = ?, case_passflag = ?, case_updatedt= ? where case_id= ?";

        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        int id = testcase.getId();
        int NUM =testcase.getNum();
        int PIRORITY =testcase.getPirority();
        String NAME =testcase.getName();
        String PRECONDITION =testcase.getPrecondition();
        String BODY =testcase.getBody();
        String ASSERTION =testcase.getAssertion();
        int PASSFLAG =testcase.getPass_flag();

        int count = jdbcTemplate.update(sql, NUM, PIRORITY, NAME, PRECONDITION, BODY, ASSERTION, PASSFLAG, date, id);
        return count;
    }

    @Override
    public int deleteByID(int id) {
        String sql = "update qa_case set  case_deleted_flag =1, case_deleted_comment = '页面逻辑删除', case_updatedt= ? where case_id= ?";
        Date dt = new Date();
        SimpleDateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);
        int count = jdbcTemplate.update(sql, date, id);
        return count;
    }
}
