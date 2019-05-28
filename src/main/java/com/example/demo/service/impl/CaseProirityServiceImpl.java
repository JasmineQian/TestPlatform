package com.example.demo.service.impl;

import com.example.demo.bean.CaseProirity;
import com.example.demo.jdbc.CaseProirityRowMapper;
import com.example.demo.service.CaseProirityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseProirityServiceImpl implements CaseProirityService {

    @Value("${dateformat}")
    String dateformat;


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<CaseProirity> findAllCaseProirity() {
        String sql = "select pirority_id,pirority_name  from qa_pirority order by pirority_id";
        List<CaseProirity> lists = jdbcTemplate.query(sql,new CaseProirityRowMapper());
        return lists;
    }
}
