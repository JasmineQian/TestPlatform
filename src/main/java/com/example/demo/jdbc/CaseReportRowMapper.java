package com.example.demo.jdbc;

import com.example.demo.bean.CaseReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseReportRowMapper implements RowMapper<CaseReport> {
    @Override
    public CaseReport mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int task_id = resultSet.getInt("task_id");
        String project_name = resultSet.getString("project_name");
        String object_name = resultSet.getString("object_name");
        String task_name = resultSet.getString("task_name");
        String task_crname = resultSet.getString("task_crname");
        String task_description = resultSet.getString("task_description");
        String task_details = resultSet.getString("task_details");
        String task_note = resultSet.getString("task_note");
        String case_id = resultSet.getString("case_id");
        int case_num = resultSet.getInt("case_num");
        String pirority_name = resultSet.getString("pirority_name");
        String case_name = resultSet.getString("case_name");
        String case_precondition = resultSet.getString("case_precondition");
        String case_body = resultSet.getString("case_body");
        String case_assertion = resultSet.getString("case_assertion");
        String casepassflag_name = resultSet.getString("casepassflag_name");
        String case_memo = resultSet.getString("case_memo");
        String case_creationdt = resultSet.getString("case_creationdt");
        String case_updatedt = resultSet.getString("case_updatedt");

        CaseReport caseReport = new CaseReport();
        caseReport.setTask_id(task_id);
        caseReport.setProject_name(project_name);
        caseReport.setObject_name(object_name);
        caseReport.setTask_name(task_name);
        caseReport.setTask_crname(task_crname);
        caseReport.setTask_description(task_description);
        caseReport.setTask_details(task_details);
        caseReport.setTask_note(task_note);
        caseReport.setCase_id(case_id);
        caseReport.setCase_num(case_num);
        caseReport.setPirority_name(pirority_name);
        caseReport.setCase_name(case_name);
        caseReport.setCase_precondition(case_precondition);
        caseReport.setCase_body(case_body);
        caseReport.setCase_assertion(case_assertion);
        caseReport.setCasepassflag_name(casepassflag_name);
        caseReport.setCase_memo(case_memo);
        caseReport.setCase_creationdt(case_creationdt);
        caseReport.setCase_updatedt(case_updatedt);

        return caseReport;
    }
}
