package com.example.demo.service.impl;

import com.example.demo.bean.BugStatus;
import com.example.demo.jdbc.BugStatusRowMapper;
import com.example.demo.service.BugStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BugStatusServiceImpl implements BugStatusService {

    @Value("${dateformat}")
    String dateformat;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BugStatus> findBugStatus() {
        String sql= "select status_id,status_des from qa_bugstatus where status_deleted_flag =0";
        List<BugStatus> lists=jdbcTemplate.query(sql,new BugStatusRowMapper());
        return lists;
    }
}
