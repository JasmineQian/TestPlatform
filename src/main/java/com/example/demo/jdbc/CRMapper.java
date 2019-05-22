package com.example.demo.jdbc;



import com.example.demo.bean.CR;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CRMapper implements RowMapper<CR> {

    @Override
    public CR mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        long id = resultSet.getInt(1);
        String name = resultSet.getString(2);

        CR testtype = new CR();
        testtype.setId(id);
        testtype.setName(name);
        return testtype;
    }

}
