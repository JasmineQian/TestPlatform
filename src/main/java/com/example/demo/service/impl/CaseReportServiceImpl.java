package com.example.demo.service.impl;

import com.example.demo.bean.CaseReport;
import com.example.demo.jdbc.CaseReportRowMapper;
import com.example.demo.service.CaseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseReportServiceImpl implements CaseReportService {

    @Value("${dateformat}")
    String dateformat;


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<CaseReport> findByCondtion(int pid, String name, String description) {
        String sql = "select task_id,project_name,object_name,task_name,task_crname,task_description,task_details,task_note,\n" +
                "case_id,case_taskid,case_num,pirority_name,case_name,case_precondition,case_body,case_assertion,casepassflag_name,case_memo,case_creationdt,case_updatedt\n" +
                "from qa_task join qa_case on task_id = case_taskid\n" +
                "join qa_project on task_pid = project_id\n" +
                "join qa_rtype on object_id = task_tid\n" +
                "join qa_pirority on pirority_id = case_pirority\n" +
                "join qa_casepassflag on casepassflag_id = case_passflag\n" +
                "where task_deleted_flag =0";

        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and task_pid = ? ";
            queryList.add(pid);
        }
        if (name!=null) {
            sql += " and task_crname like ? ";
            queryList.add("%" + name.trim() + "%");
        }
        if (description!=null) {
            sql += " and task_description  like ? ";
            queryList.add("%" + description.trim() + "%");
        }


        List<CaseReport> lists = jdbcTemplate.query(sql, queryList.toArray(), new CaseReportRowMapper());
        return lists;
    }
}
