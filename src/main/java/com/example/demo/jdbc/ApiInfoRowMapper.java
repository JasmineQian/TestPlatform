package com.example.demo.jdbc;

import com.example.demo.bean.ApiInfoBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApiInfoRowMapper implements RowMapper<ApiInfoBean> {


    @Override
    public ApiInfoBean mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性

        int id = resultSet.getInt("ID");
        int pid = resultSet.getInt("PID");
        String projectname = resultSet.getString("PROJECT_NAME");
        String name = resultSet.getString("NAME");
        String hostname = resultSet.getString("HOSTNAME");
        String path = resultSet.getString("PATH");
        String memo = resultSet.getString("MEMO");
        String createdt = resultSet.getString("CREATEDT");
        String updatedt = resultSet.getString("UPDATEDT");

        ApiInfoBean apiInfoBean = new ApiInfoBean();
        apiInfoBean.setid(id);
        apiInfoBean.setpid(pid);
        apiInfoBean.setporjectname(projectname);
        apiInfoBean.setname(name);
        apiInfoBean.sethostname(hostname);
        apiInfoBean.setpath(path);
        apiInfoBean.setmemo(memo);
        apiInfoBean.setcreatdt(createdt);
        apiInfoBean.setupdatedt(updatedt);
        return apiInfoBean;
    }
}
