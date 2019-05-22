package com.example.demo.jdbc;

import com.example.demo.bean.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectMapper implements RowMapper<Project> {


    @Override
    public Project mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        long pid = resultSet.getInt("project_id");
        String pname = resultSet.getString("project_name");
        String pcreationdt = resultSet.getString("project_creation_dt");
        String pupdatedt = resultSet.getString("project_update_dt");

        Project project = new Project();
        project.setPid(pid);
        project.setPname(pname);
        project.setPcreationdt(pcreationdt);
        project.setPupdatedt(pupdatedt);

        return project;
    }

}
