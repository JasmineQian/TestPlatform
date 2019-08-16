package com.example.demo.jdbc;

import com.example.demo.bean.ApiInfoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApiInfoRowMapper implements RowMapper<ApiInfoBean> {


    @Override
    public ApiInfoBean mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性

        int id = resultSet.getInt("api_id");
        int pid = resultSet.getInt("api_pid");
        String projectname = resultSet.getString("project_name");
        String name = resultSet.getString("api_name");
        String hostname = resultSet.getString("api_hostname");
        String path = resultSet.getString("api_path");
        String memo = resultSet.getString("api_memo");
        String createdt = resultSet.getString("api_createdt");
        String updatedt = resultSet.getString("api_updatedt");

        ApiInfoBean apiInfoBean = new ApiInfoBean();
        apiInfoBean.setId(id);
        apiInfoBean.setPid(pid);
        apiInfoBean.setProjectname(projectname);
        apiInfoBean.setName(name);
        apiInfoBean.setHostname(hostname);
        apiInfoBean.setPath(path);
        apiInfoBean.setMemo(memo);
        apiInfoBean.setCreatdt(createdt);
        apiInfoBean.setUpdatedt(updatedt);
        return apiInfoBean;
    }
}
