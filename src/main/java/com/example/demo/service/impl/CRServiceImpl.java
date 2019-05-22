package com.example.demo.service.impl;

import com.example.demo.bean.CR;
import com.example.demo.jdbc.CRMapper;
import com.example.demo.service.CRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRServiceImpl implements CRService {


    @Value("${dateformat}")
    String dateformat;


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<CR> findCRType() {
        String sql = "select cr_id,cr_name from qa_crtype where cr_deleted_flag = 0";
        List<CR> crtype= jdbcTemplate.query(sql,new CRMapper() );
        return crtype;
    }
}
