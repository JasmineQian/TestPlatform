package com.example.demo.jdbc;

import com.example.demo.bean.Case;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseRowMapper implements RowMapper<Case> {
    @Override
    public Case mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int id = resultSet.getInt("case_id");
        int taskid =resultSet.getInt("case_taskid");
        String taskname = resultSet.getString("task_name");
        int num =resultSet.getInt("case_num");
        int pirority = resultSet.getInt("case_pirority");
        String piroritymemo = resultSet.getString("pirority_name");
        String name = resultSet.getString("case_name");
        String precondition = resultSet.getString("case_precondition");
        String body = resultSet.getString("case_body");;
        String assertion = resultSet.getString("case_assertion");
        int pass_flag = resultSet.getInt("case_passflag");
        String passflagmemo = resultSet.getString("casepassflag_name");
        String memo = resultSet.getString("case_memo");
        String creationdt = resultSet.getString("case_creationdt");;
        String updatedt = resultSet.getString("case_updatedt");;

        Case testcase= new Case();
        testcase.setId(id);
        testcase.setTaskid(taskid);
        testcase.setTaskname(taskname);
        testcase.setNum(num);
        testcase.setPirority(pirority);
        testcase.setPiroritymemo(piroritymemo);
        testcase.setName(name);
        testcase.setPrecondition(precondition);
        testcase.setBody(body);
        testcase.setAssertion(assertion);
        testcase.setPass_flag(pass_flag);
        testcase.setPass_memo(passflagmemo);
        testcase.setMemo(memo);
        testcase.setCreationdt(creationdt);
        testcase.setUpdatedt(updatedt);

        return testcase;
    }
}
