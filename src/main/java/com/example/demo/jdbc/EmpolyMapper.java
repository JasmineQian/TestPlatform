package com.example.demo.jdbc;

import com.example.demo.bean.Employ;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpolyMapper implements RowMapper<Employ> {


    @Override
    public Employ mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        long eid = resultSet.getInt(1);
        String ename = resultSet.getString(2);

        Employ employ = new Employ();
        employ.setEid(eid);
        employ.setEname(ename);
        return employ;
    }
}
