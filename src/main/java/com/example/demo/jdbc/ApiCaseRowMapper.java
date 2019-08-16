package com.example.demo.jdbc;

import com.example.demo.bean.ApiCaseBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ApiCaseRowMapper implements RowMapper<ApiCaseBean> {

    @Override
    public ApiCaseBean mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性

        int id = resultSet.getInt("apicase_id");
        int api_pid = resultSet.getInt("api_pid");
        String projectname = resultSet.getString("project_name");
        int api_id = resultSet.getInt("api_id");
        String api_name = resultSet.getString("api_name");
        String name = resultSet.getString("apicase_name");
        String body = resultSet.getString("apicase_body");
        String asserction = resultSet.getString("apicase_asserction");
        int priorityid = resultSet.getInt("apicase_priorityid");
        String priorityname = resultSet.getString("pirority_name");
        int passid = resultSet.getInt("apicase_passid");
        String pass = resultSet.getString("casepassflag_name");
        String memo = resultSet.getString("apicase_memo");
        String createdt = resultSet.getString("apicase_createdt");
        String updatedt = resultSet.getString("apicase_updatedt");
        int casetype_id = resultSet.getInt("apicase_typeid");

        ApiCaseBean apiCaseBean = new ApiCaseBean();
        apiCaseBean.setNum(id);
        apiCaseBean.setPid(api_pid);
        apiCaseBean.setProjectname(projectname);
        apiCaseBean.setTaskid(api_id);
        apiCaseBean.setTaskname(api_name);
        apiCaseBean.setName(name);
        apiCaseBean.setBody(body);
        apiCaseBean.setAsseertion(asserction);
        apiCaseBean.setPriorityid(priorityid);
        apiCaseBean.setPriority(priorityname);
        apiCaseBean.setPassid(passid);
        apiCaseBean.setPassinfo(pass);
        apiCaseBean.setMemo(memo);
        apiCaseBean.setCreatedt(createdt);
        apiCaseBean.setUpdatedt(updatedt);
        apiCaseBean.setCasetype_id(casetype_id);

        return apiCaseBean;


    }
}
