package com.example.demo.jdbc;

import com.example.demo.bean.Case;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseRowMapper implements RowMapper<Case> {
    @Override
    public Case mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int id = resultSet.getInt("id");
        int taskid =resultSet.getInt("taskid");
        String taskname = resultSet.getString("task_name");
        int num =resultSet.getInt("num");
        int pirority = resultSet.getInt("pirority");
        String piroritymemo = resultSet.getString("pirority_name");
        String name = resultSet.getString("name");
        String precondition = resultSet.getString("precondition");
        String body = resultSet.getString("body");;
        String assertion = resultSet.getString("assertion");
        int pass_flag = resultSet.getInt("passflag");
        String passflagmemo = resultSet.getString("casepassflag_name");
        String memo = resultSet.getString("memo");
        String creationdt = resultSet.getString("creationdt");;
        String updatedt = resultSet.getString("updatedt");;

        Case testcase= new Case();
        testcase.setid(id);
        testcase.settaskid(taskid);
        testcase.settaskname(taskname);
        testcase.setnum(num);
        testcase.setpirority(pirority);
        testcase.setpiroritymemo(piroritymemo);
        testcase.setname(name);
        testcase.setprecondition(precondition);
        testcase.setbody(body);
        testcase.setassertion(assertion);
        testcase.setpass_flag(pass_flag);
        testcase.setpass_memo(passflagmemo);
        testcase.setmemo(memo);
        testcase.setCreationdt(creationdt);
        testcase.setUpdatedt(updatedt);

        return testcase;
    }
}
