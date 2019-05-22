package com.example.demo.jdbc;

import com.example.demo.bean.Case;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseRowMapper implements RowMapper<Case> {
    @Override
    public Case mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int case_id = resultSet.getInt("case_id");
        int case_taskid =resultSet.getInt("case_taskid");
        String case_taskname = resultSet.getString("task_name");
        int case_num =resultSet.getInt("case_num");
        int case_pirority = resultSet.getInt("case_pirority");
        String case_piroritymemo = resultSet.getString("pirority_name");
        String case_name = resultSet.getString("case_name");
        String case_precondition = resultSet.getString("case_precondition");
        String case_body = resultSet.getString("case_body");;
        String case_assertion = resultSet.getString("case_assertion");
        int case_pass_flag = resultSet.getInt("case_passflag");
        String case_passflagmemo = resultSet.getString("casepassflag_name");
        String case_memo = resultSet.getString("case_memo");
        String creationdt = resultSet.getString("case_creationdt");;
        String updatedt = resultSet.getString("case_updatedt");;

        Case testcase= new Case();
        testcase.setCase_id(case_id);
        testcase.setCase_taskid(case_taskid);
        testcase.setCase_taskname(case_taskname);
        testcase.setCase_num(case_num);
        testcase.setCase_pirority(case_pirority);
        testcase.setCase_piroritymemo(case_piroritymemo);
        testcase.setCase_name(case_name);
        testcase.setCase_precondition(case_precondition);
        testcase.setCase_body(case_body);
        testcase.setCase_assertion(case_assertion);
        testcase.setCase_pass_flag(case_pass_flag);
        testcase.setCase_pass_memo(case_passflagmemo);
        testcase.setCase_memo(case_memo);
        testcase.setCreationdt(creationdt);
        testcase.setUpdatedt(updatedt);

        return testcase;
    }
}
