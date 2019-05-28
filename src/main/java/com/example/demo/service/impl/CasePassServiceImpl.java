package com.example.demo.service.impl;

import com.example.demo.bean.CasePass;
import com.example.demo.jdbc.CasePassRowMapper;
import com.example.demo.service.CasePassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CasePassServiceImpl implements CasePassService {

    @Value("${dateformat}")
    String dateformat;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CasePass> findAllPass() {
        String sql="select casepassflag_id,casepassflag_name from qa_casepassflag order by casepassflag_id";
        List<CasePass> lists = jdbcTemplate.query(sql,new CasePassRowMapper());
        return lists;

    }
}
