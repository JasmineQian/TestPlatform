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

        String sql = "select api_id,api_pid,project_name,api_name,api_hostname,api_path,api_memo,api_createdt,api_updatedt\n" +
                "from qa_api join qa_project on api_pid =project_id where api_deleted_flag = 0 ";

        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and api_pid = ? ";
            queryList.add(pid);
        }
        if (apiname != null) {
            sql += " and api_name like ? ";
            queryList.add("%" + apiname.trim() + "%");
        }
        String sql2 = sql + " order by 1 desc limit " + start + " , 20";
        //String sql2 = sql+" order by 1 desc offset  "+ start+  "  rows fetch next  20 rows only";
        List<ApiInfoBean> lists = jdbcTemplate.query(sql2, queryList.toArray(), new ApiInfoRowMapper());
        return lists;
    }

    @Override
    public int countAll(int pageon, int pid, String apiname) {
        String sql = "select api_id,api_pid,project_name,api_name,api_hostname,api_path,api_memo,api_createdt,api_updatedt\n" +
                "from qa_api join qa_project on api_pid =project_id where api_deleted_flag = 0 ";

        List<Object> queryList = new ArrayList<Object>();
        if (pid != 0) {
            sql += " and api_pid = ? ";
            queryList.add(pid);
        }
        if (apiname != null) {
            sql += " and api_name like ? ";
            queryList.add("%" + apiname.trim() + "%");
        }
        return jdbcTemplate.query(sql, queryList.toArray(), new ApiInfoRowMapper()).size();
    }

    @Override
    public ApiInfoBean findApiById(int id) {
        String sql = "select api_id, api_pid,project_name,api_name,api_hostname,api_path,api_memo,api_createdt,api_updatedt\n" +
                "from qa_api join qa_project on api_pid =project_id where api_deleted_flag = 0 and api_id =? ";
        ApiInfoBean apiInfoBean = jdbcTemplate.queryForObject(sql, new ApiInfoRowMapper(), id);

        return apiInfoBean;
    }

    @Override
    public int createApi(ApiInfoBean apiInfoBean) {


        String sql = "insert qa_api (api_pid,api_name,api_hostname,api_path,api_memo,api_createdt,api_updatedt) \n" +
                "values(?,?,?,?,?,?,?)";

        int pid = apiInfoBean.getApi_pid();
        String api_name = apiInfoBean.getApi_name();
        String hostname = apiInfoBean.getApi_hostname();
        String path = apiInfoBean.getApi_path();
        String memo = apiInfoBean.getApi_memo();

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int count = jdbcTemplate.update(sql, pid, api_name, hostname, path, memo, date, date);
        return count;
    }

    @Override
    public int updateApi(ApiInfoBean apiInfoBean) {
        String sql = "update qa_api set api_name= ?,api_hostname = ?,api_path= ?,api_memo =?,api_updatedt =?\n" +
                "where api_id= ? and api_pid = ? and api_deleted_flag = 0";
        int id = apiInfoBean.getApi_id();
        int pid = apiInfoBean.getApi_pid();
        String api_name = apiInfoBean.getApi_name();
        String hostname = apiInfoBean.getApi_hostname();
        String path = apiInfoBean.getApi_path();
        String memo = apiInfoBean.getApi_memo();
        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);
        int count = jdbcTemplate.update(sql, api_name, hostname, path, memo, date, id, pid);
        return count;
    }

    @Override
    public int deleteApi(int id) {
        String sql = "update qa_api set  api_deleted_flag = 1 ,api_updatedt =? where api_id= ? ";

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int count = jdbcTemplate.update(sql, date, id);
        return count;
    }
}
