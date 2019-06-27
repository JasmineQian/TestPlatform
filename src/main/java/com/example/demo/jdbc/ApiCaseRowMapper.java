package com.example.demo.jdbc;

import com.example.demo.bean.ApiCaseBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ApiCaseRowMapper implements RowMapper<ApiCaseBean> {

    @Override
    public ApiCaseBean mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性

        int apicase_id = resultSet.getInt("apicase_id");
        int api_pid = resultSet.getInt("api_pid");
        String projectname = resultSet.getString("project_name");
        int api_id = resultSet.getInt("api_id");
        String api_name = resultSet.getString("api_name");
        String apicase_name = resultSet.getString("apicase_name");
        String apicase_body = resultSet.getString("apicase_body");
        String apicase_asserction = resultSet.getString("apicase_asserction");
        int apicase_priorityid = resultSet.getInt("apicase_priorityid");
        String apicase_priorityname = resultSet.getString("pirority_name");
        int apicase_passid = resultSet.getInt("apicase_passid");
        String apicase_pass = resultSet.getString("casepassflag_name");
        String apicase_memo = resultSet.getString("apicase_memo");
        String createdt = resultSet.getString("apicase_createdt");
        String updatedt = resultSet.getString("apicase_updatedt");
        int casetype_id = resultSet.getInt("apicase_typeid");

        ApiCaseBean apiCaseBean = new ApiCaseBean();
        apiCaseBean.setApiCase_num(apicase_id);
        apiCaseBean.setApiCase_pid(api_pid);
        apiCaseBean.setApiCase_projectname(projectname);
        apiCaseBean.setApiCase_taskid(api_id);
        apiCaseBean.setApiCase_taskname(api_name);
        apiCaseBean.setApiCase_name(apicase_name);
        apiCaseBean.setApiCase_body(apicase_body);
        apiCaseBean.setApiCase_asseertion(apicase_asserction);
        apiCaseBean.setApiCase_priorityid(apicase_priorityid);
        apiCaseBean.setApiCase_priority(apicase_priorityname);
        apiCaseBean.setApiCase_passid(apicase_passid);
        apiCaseBean.setApiCase_passinfo(apicase_pass);
        apiCaseBean.setApiCase_memo(apicase_memo);
        apiCaseBean.setCreatedt(createdt);
        apiCaseBean.setUpdatedt(updatedt);
        apiCaseBean.setCasetype_id(casetype_id);

        return apiCaseBean;


    }
}
