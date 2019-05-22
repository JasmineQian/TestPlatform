package com.example.demo.service.impl;

import com.example.demo.bean.Project;
import com.example.demo.jdbc.ProjectMapper;
import com.example.demo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Value("${dateformat}")
    String dateformat;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Project> findAll() {
        String sql = "select project_id,project_name,project_creation_dt,project_update_dt from qa_project where project_deleted_flag = 0";
        List<Project> projects = jdbcTemplate.query(sql,new ProjectMapper() );
        return projects;

    }
}
