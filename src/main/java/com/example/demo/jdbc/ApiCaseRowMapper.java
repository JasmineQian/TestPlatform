package com.example.demo.jdbc;

import com.example.demo.bean.ApiCaseBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ApiCaseRowMapper implements RowMapper<ApiCaseBean> {

    @Override
    public ApiCaseBean mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性

        int id = resultSet.getInt("id");
        int api_pid = resultSet.getInt("api_pid");
        String projectname = resultSet.getString("project_name");
        int api_id = resultSet.getInt("api_id");
        String api_name = resultSet.getString("api_name");
        String name = resultSet.getString("name");
        String body = resultSet.getString("body");
        String asserction = resultSet.getString("asserction");
        int priorityid = resultSet.getInt("priorityid");
        String priorityname = resultSet.getString("pirority_name");
        int passid = resultSet.getInt("passid");
        String pass = resultSet.getString("casepassflag_name");
        String memo = resultSet.getString("memo");
        String createdt = resultSet.getString("createdt");
        String updatedt = resultSet.getString("updatedt");
        int casetype_id = resultSet.getInt("typeid");

        ApiCaseBean apiCaseBean = new ApiCaseBean();
        apiCaseBean.setnum(id);
        apiCaseBean.setpid(api_pid);
        apiCaseBean.setprojectname(projectname);
        apiCaseBean.settaskid(api_id);
        apiCaseBean.settaskname(api_name);
        apiCaseBean.setname(name);
        apiCaseBean.setbody(body);
        apiCaseBean.setasseertion(asserction);
        apiCaseBean.setpriorityid(priorityid);
        apiCaseBean.setpriority(priorityname);
        apiCaseBean.setpassid(passid);
        apiCaseBean.setpassinfo(pass);
        apiCaseBean.setmemo(memo);
        apiCaseBean.setCreatedt(createdt);
        apiCaseBean.setUpdatedt(updatedt);
        apiCaseBean.setCasetype_id(casetype_id);

        return apiCaseBean;


    }
}
