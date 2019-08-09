package com.example.demo.service.impl;

import com.example.demo.bean.ApiInfoBean;
import com.example.demo.jdbc.ApiInfoRowMapper;
import com.example.demo.service.ApiInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApiInfoServiceImpl implements ApiInfoService {

    @Value("${dateformat}")
    String dateformat;


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ApiInfoBean> findAllApi(int pageon, int pid, String apiname) {
        int start = (pageon - 1) * 20;

        String sql = "select id,pid,project_name,name,hostname,path,memo,createdt,updatedt\n" +
                "from qa_api join qa_project on pid =project_id where deleted_flag = 0 ";

        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and pid = ? ";
            queryList.add(pid);
        }
        if (apiname != null) {
            sql += " and name like ? ";
            queryList.add("%" + apiname.trim() + "%");
        }
        String sql2 = sql + " order by 1 desc limit " + start + " , 20";
        //String sql2 = sql+" order by 1 desc offset  "+ start+  "  rows fetch next  20 rows only";
        List<ApiInfoBean> lists = jdbcTemplate.query(sql2, queryList.toArray(), new ApiInfoRowMapper());
        return lists;
    }

    @Override
    public int countAll(int pageon, int pid, String apiname) {
        String sql = "select id,pid,project_name,name,hostname,path,memo,createdt,updatedt\n" +
                "from qa_api join qa_project on pid =project_id where deleted_flag = 0 ";

        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and pid = ? ";
            queryList.add(pid);
        }
        if (apiname != null) {
            sql += " and name like ? ";
            queryList.add("%" + apiname.trim() + "%");
        }
        return jdbcTemplate.query(sql, queryList.toArray(), new ApiInfoRowMapper()).size();
    }

    @Override
    public ApiInfoBean findApiById(int id) {
        String sql = "select id, pid,project_name,name,hostname,path,memo,createdt,updatedt\n" +
                "from qa_api join qa_project on pid =project_id where deleted_flag = 0 and id =? ";
        ApiInfoBean apiInfoBean = jdbcTemplate.queryForObject(sql, new ApiInfoRowMapper(), id);

        return apiInfoBean;
    }

    @Override
    public int createApi(ApiInfoBean apiInfoBean) {


        String sql = "insert qa_api (pid,name,hostname,path,memo,createdt,updatedt) \n" +
                "values(?,?,?,?,?,?,?)";

        int pid = apiInfoBean.getpid();
        String name = apiInfoBean.getname();
        String hostname = apiInfoBean.gethostname();
        String path = apiInfoBean.getpath();
        String memo = apiInfoBean.getmemo();

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int count = jdbcTemplate.update(sql, pid, name, hostname, path, memo, date, date);
        return count;
    }

    @Override
    public int updateApi(ApiInfoBean apiInfoBean) {
        String sql = "update qa_api set name= ?,hostname = ?,path= ?,memo =?,updatedt =?\n" +
                "where id= ? and pid = ? and deleted_flag = 0";
        int id = apiInfoBean.getid();
        int pid = apiInfoBean.getpid();
        String name = apiInfoBean.getname();
        String hostname = apiInfoBean.gethostname();
        String path = apiInfoBean.getpath();
        String memo = apiInfoBean.getmemo();
        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);
        int count = jdbcTemplate.update(sql, name, hostname, path, memo, date, id, pid);
        return count;
    }

    @Override
    public int deleteApi(int id) {
        String sql = "update qa_api set  deleted_flag = 1 ,updatedt =? where id= ? ";

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int count = jdbcTemplate.update(sql, date, id);
        return count;
    }
}
