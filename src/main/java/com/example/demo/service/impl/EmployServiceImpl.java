package com.example.demo.service.impl;

import com.example.demo.bean.Employ;
import com.example.demo.jdbc.EmpolyMapper;
import com.example.demo.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployServiceImpl implements EmployService {

    @Value("${dateformat}")
    String dateformat;



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employ> findTester() {
        String sql = "select employ_id,employ_name from qa_employ where employ_group = 1 and employ_deleted_flag=0";
        List<Employ> tester= jdbcTemplate.query(sql,new EmpolyMapper() );
        return tester;
    }

    @Override
    public List<Employ> findDeveloper() {
        String sql = "select employ_id,employ_name from qa_employ where employ_group = 2 and employ_deleted_flag=0";
        List<Employ> developer= jdbcTemplate.query(sql,new EmpolyMapper() );
        return developer;
    }


}
