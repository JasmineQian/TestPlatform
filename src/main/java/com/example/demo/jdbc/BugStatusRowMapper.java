package com.example.demo.jdbc;

import com.example.demo.bean.BugStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BugStatusRowMapper implements RowMapper<BugStatus> {
    @Override
    public BugStatus mapRow(ResultSet resultSet, int i) throws SQLException {

        //此处要使用表中的字段，不能使用属性
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);

        BugStatus bugStatus = new BugStatus();
        bugStatus.setBugid(id);
        bugStatus.setBugStatus(name);

        return bugStatus;
    }
}
