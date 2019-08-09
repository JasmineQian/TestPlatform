package com.example.demo.service.impl;

import com.example.demo.bean.ApiCaseBean;
import com.example.demo.jdbc.ApiCaseRowMapper;
import com.example.demo.service.ApiCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class ApiCaseServiceImpl implements ApiCaseService {

    @Value("${dateformat}")
    String dateformat;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int add(ApiCaseBean apiCaseBean) {
        int api_id = apiCaseBean.gettaskid();
        String name = apiCaseBean.getname();
        String body = apiCaseBean.getbody();
        String asser = apiCaseBean.getasseertion();
        int pirority = apiCaseBean.getpriorityid();
        int typeid = apiCaseBean.getCasetype_id();
        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);

        String date = bf.format(dt);
        String sql = "insert qa_apicase(api_id,name,body,asserction,priorityid,typeid,createdt,updatedt)\n" +
                "values(?,?,?,?,?,?,?,?) \n";
        return jdbcTemplate.update(sql, api_id,name, body, asser, pirority, typeid,date, date);

    }

    @Override
    public List<ApiCaseBean> findApiCaseById(int apiID) {
        String sql = "select  id,api_pid,project_name,qa_apicase.api_id as api_id,api_name,name,body,typeid,\n" +
                "asserction,priorityid,pirority_name,passid,casepassflag_name,memo,createdt,updatedt\n" +
                "from qa_apicase join qa_api on qa_apicase.api_id = qa_api.api_id\n" +
                "join qa_project on project_id = api_pid\n" +
                "join qa_pirority on priorityid = pirority_id\n" +
                "left join qa_casepassflag on casepassflag_id = passid\n" +
                "where deleted_flag = 0 and qa_apicase.api_id = ?";
        List<ApiCaseBean> lists =jdbcTemplate.query(sql,new ApiCaseRowMapper(),apiID);
        return lists;
    }

    @Override
    public ApiCaseBean findApiCase(int id) {
        String sql= "select  id,api_pid,project_name,qa_apicase.api_id as api_id,api_name,name,body,typeid,\n" +
                "asserction,priorityid,pirority_name,passid,casepassflag_name,memo,createdt,updatedt\n" +
                "from qa_apicase join qa_api on qa_apicase.api_id = qa_api.api_id\n" +
                "join qa_project on project_id = api_pid\n" +
                "join qa_pirority on priorityid = pirority_id\n" +
                "left join qa_casepassflag on casepassflag_id = passid\n" +
                "where deleted_flag = 0\n" +
                "and id = ?";
        ApiCaseBean apiCaseBean = jdbcTemplate.queryForObject(sql,new ApiCaseRowMapper(),id);
        return apiCaseBean;
    }

    @Override
    public int update(ApiCaseBean apiCaseBean) {
        String sql="update qa_apicase set name=?,body=?, asserction=?, priorityid=?, passid=?,\n" +
                "memo= ?, updatedt =? where id = ? and api_id= ?";
        int id = apiCaseBean.getnum();
        int apiid =apiCaseBean.gettaskid();
        String casename = apiCaseBean.getname();
        String body = apiCaseBean.getbody();
        String asserction  =apiCaseBean.getasseertion();
        int priority = apiCaseBean.getpriorityid();
        int pass = apiCaseBean.getpassid();
        String memo = apiCaseBean.getmemo();
        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int count = jdbcTemplate.update(sql,casename,body,asserction,priority,pass,memo, date, id,apiid);
        return count;
    }

    //按照所在的接口api_id以及测试用例的种类进行删除
    //频繁地操作一张表，可能会进行锁表

    @Override
    public int deleteByTypeId(int id, int typeid) {
        String sql="delete from qa_apicase where api_id= ? and typeid = ?";
        int count =jdbcTemplate.update(sql, id,typeid);
        return 0;
    }


    @Override
    public int delete(int id) {
        String sql = "update qa_apicase set deleted_flag = 1 , updatedt = ? where id = ? ";
        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);
        int count = jdbcTemplate.update(sql, date, id);
        return count;
    }
}
