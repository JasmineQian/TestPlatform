package com.example.demo.service.impl;


import com.example.demo.bean.UserEntity;
import com.example.demo.jdbc.UserRowMapper;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Primary
public class UserServiceImpl implements UserService {

    // 记录器
    Logger logger = LoggerFactory.getLogger(getClass());


    @Value("${dateformat}")
    String dateformat;

    @Value("${roles}")
    String roles;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(UserEntity userEntity) {

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        String username =userEntity.getUsername();
        String password =userEntity.getPassword();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass =passwordEncoder.encode(password);

        String nickname =userEntity.getNickname();
        String role =roles;

        String sql = "insert into qa_user(username,password,nickname,roles,creationdt,updatedt) values(?,?,?,?,?,?)";
        int count = jdbcTemplate.update(sql,username,pass,nickname,role,date,date);
        return count;
    }

    @Override
    public UserEntity getByUsername(String username) {
        String sql ="select * from qa_user where username =? ";
        UserEntity userEntity = jdbcTemplate.queryForObject(sql,new UserRowMapper(),username);
        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);
        logger.info(date);
        logger.info(userEntity.toString());
        System.out.println(date);
        System.out.println(userEntity);
        return userEntity;
    }

    @Override
    public int checkUsername(String username) {
        String sql ="select * from qa_user where username =? ";
        int count = jdbcTemplate.query(sql,new UserRowMapper(),username).size();
        return count;
    }

}
