package com.example.demo.jdbc;

import com.example.demo.bean.ApiInfoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApiInfoRowMapper implements RowMapper<ApiInfoBean> {


    @Override
    public ApiInfoBean mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性

        int api_id = resultSet.getInt("API_ID");
        int api_pid = resultSet.getInt("API_PID");
        String projectname = resultSet.getString("PROJECT_NAME");
        String api_name = resultSet.getString("API_NAME");
        String api_hostname = resultSet.getString("API_HOSTNAME");
        String api_path = resultSet.getString("API_PATH");
        String api_memo = resultSet.getString("API_MEMO");
        String createdt = resultSet.getString("API_CREATEDT");
        String updatedt = resultSet.getString("API_UPDATEDT");

        ApiInfoBean apiInfoBean = new ApiInfoBean();
        apiInfoBean.setApi_id(api_id);
        apiInfoBean.setApi_pid(api_pid);
        apiInfoBean.setApi_porjectname(projectname);
        apiInfoBean.setApi_name(api_name);
        apiInfoBean.setApi_hostname(api_hostname);
        apiInfoBean.setApi_path(api_path);
        apiInfoBean.setApi_memo(api_memo);
        apiInfoBean.setApi_creatdt(createdt);
        apiInfoBean.setApi_updatedt(updatedt);
        return apiInfoBean;
    }
}
