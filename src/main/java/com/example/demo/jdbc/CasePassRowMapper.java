package com.example.demo.jdbc;

import com.example.demo.bean.BugStatus;
import com.example.demo.bean.CasePass;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CasePassRowMapper implements RowMapper<CasePass> {
    @Override
    public CasePass mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);

        CasePass casePass = new CasePass();
        casePass.setId(id);
        casePass.setName(name);

        return casePass;
    }
}
