package com.example.demo.jdbc;

import com.example.demo.bean.CasePass;
import com.example.demo.bean.CaseProirity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CaseProirityRowMapper implements RowMapper<CaseProirity> {

    @Override
    public CaseProirity mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);

        CaseProirity caseProirity = new CaseProirity();
        caseProirity.setId(id);
        caseProirity.setName(name);

        return caseProirity;
    }
}
