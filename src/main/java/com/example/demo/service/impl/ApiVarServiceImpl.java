package com.example.demo.service.impl;

import com.example.demo.bean.ApiVarBean;
import com.example.demo.jdbc.ApiVarBeanRowMapper;
import com.example.demo.service.ApiVarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ApiVarServiceImpl implements ApiVarService {

    @Value("${dateformat}")
    String dateformat;



    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(ApiVarBean apiVarBean) {

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int num = apiVarBean.getNum();
        String valname = apiVarBean.getVal();
        String valsample = apiVarBean.getVal_sample();
        int mamdatoryflag = apiVarBean.getInputFlag();
        String Type = apiVarBean.getInputDataType();
        int TypeID = apiVarBean.getInputTypeID();
        int length = apiVarBean.getInputLenght();
        String note = apiVarBean.getInputNote();

        String sql = "insert qa_apivar(api_id,apivar_name,apivar_sample,apivar_inputflag,apivar_inputdatatype,apivar_inputdatatypeid,\n" +
                "apivar_inputlength,apivar_inputscope,apivar_inputnote,apivar_deleted_flag,apivar_createdt,apivar_updatedt)\n" +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";

        int count = jdbcTemplate.update(sql, num, valname,valsample, mamdatoryflag, Type, TypeID,length,"scope",note,0, date, date);
        return count;

    }

    @Override
    public int saveall(List<ApiVarBean> apiVarBeanList) {
        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        String sql = "insert qa_apivar(api_id,apivar_name,apivar_inputflag,apivar_inputdatatype,apivar_inputdatatypeid,\n" +
                "apivar_inputlength,apivar_inputscope,apivar_inputnote,apivar_deleted_flag,apivar_createdt,apivar_updatedt)\n" +
                "values(?,?,?,?,?,?,?,?,?,?,?)";
        int countamount =0;

        for (int i = 0; i < apiVarBeanList.size(); i++) {
            ApiVarBean apiVarBean = new ApiVarBean();
            apiVarBean = apiVarBeanList.get(i);

            int num = i;
            String valname = apiVarBean.getVal();
            int flag = apiVarBean.getInputFlag();
            String Type = apiVarBean.getInputDataType();
            int TypeID = apiVarBean.getInputTypeID();
            int length = apiVarBean.getInputLenght();
            String note = apiVarBean.getInputNote();
            int count = jdbcTemplate.update(sql, num, valname, flag, Type, TypeID,length,"scope",note,0, date, date);
            countamount = countamount + count;
        }
        return countamount;
    }

    @Override
    public int update(ApiVarBean apiVarBean) {
        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        int num = apiVarBean.getNum();
        String valname = apiVarBean.getVal();
        String valsample = apiVarBean.getVal_sample();
        int mamdatoryflag = apiVarBean.getInputFlag();
        String Type = apiVarBean.getInputDataType();
        int TypeID = apiVarBean.getInputTypeID();
        int length = apiVarBean.getInputLenght();
        String note = apiVarBean.getInputNote();

        String sql = "update qa_apivar set apivar_name = ?,apivar_sample = ?,apivar_inputflag = ?, apivar_inputdatatype = ?,apivar_inputdatatypeid = ?,\n" +
                "apivar_inputlength = ?, apivar_inputscope = ?,apivar_inputnote = ?, apivar_updatedt = ?)";

        int count = jdbcTemplate.update(sql, num, valname,valsample, mamdatoryflag, Type, TypeID,length,"scope",note, date);
        return count;
    }

    @Override
    public int deleteByid(int id) {

        Date dt = new Date();
        DateFormat bf = new SimpleDateFormat(dateformat);
        String date = bf.format(dt);

        String sql= "update  qa_apivar  set apivar_deleted_flag  =1 ,apivar_updatedt = ? where apivar_id= ? ";
        int count=jdbcTemplate.update(sql,date,id);
        return count;
    }

    @Override
    public ApiVarBean selectByid(int id) {

        String sql= "select apivar_id,api_id,apivar_name,apivar_sample,apivar_inputflag,apivar_inputdatatype,apivar_inputdatatypeid,apivar_inputlength,apivar_inputscope,apivar_inputnote,apivar_createdt,apivar_updatedt\n" +
                "from qa_apivar where apivar_deleted_flag = 0 and apivar_id = ? ";
        ApiVarBean apiVarBean =  jdbcTemplate.queryForObject(sql,new ApiVarBeanRowMapper(),id);
        return apiVarBean;
    }

    @Override
    public List<ApiVarBean> CheckMustVar(int taskid) {
        String sql= "select apivar_id,api_id,apivar_name,apivar_sample,apivar_inputflag,apivar_inputdatatype,apivar_inputdatatypeid,apivar_inputlength,apivar_inputscope,apivar_inputnote,apivar_createdt,apivar_updatedt \n" +
                "from qa_apivar where apivar_deleted_flag = 0 and apivar_inputflag =1 and api_id = ? ";
        List<ApiVarBean>  lists=jdbcTemplate.query(sql,new ApiVarBeanRowMapper(),taskid);
        return lists;

    }

    @Override
    public List<ApiVarBean> CheckAllVar(int taskid) {
        String sql= "select apivar_id,api_id,apivar_name,apivar_sample,apivar_inputflag,apivar_inputdatatype,apivar_inputdatatypeid,apivar_inputlength,apivar_inputscope,apivar_inputnote,apivar_createdt,apivar_updatedt\n" +
                "from qa_apivar where apivar_deleted_flag = 0 and api_id = ?";
        List<ApiVarBean>  lists=jdbcTemplate.query(sql,new ApiVarBeanRowMapper(),taskid);
        return lists;
    }


}
