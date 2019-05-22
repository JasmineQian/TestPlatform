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
        int flag = apiVarBean.getInputFlag();
        String Type = apiVarBean.getInputDataType();
        int TypeID = apiVarBean.getInputTypeID();
        int length = apiVarBean.getInputLenght();
        String note = apiVarBean.getInputNote();

        //return jdbcTemplate.update(sql, pname, crname, crnum, tasknum, oname, description, rca, solution, developer, tester, date, date, bugStatus);


        return 0;
    }

    @Override
    public int saveall(List<ApiVarBean> apiVarBeanList) {
        Date dt = new Date();
        DateFormat bf = DateFormat.getDateTimeInstance();
        String date = bf.format(dt);

        String sql= "";

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
            //int count = ;
        }
        return 0;
    }

    @Override
    public List<ApiVarBean> CheckMustVar(int taskid) {
        String sql= "select apivar_id,api_id,apivar_name,apivar_inputflag,apivar_inputdatatype,apivar_inputdatatypeid,apivar_inputlength,apivar_inputscope,apivar_inputnote,apivar_createdt,apivar_updatedt \n" +
                "from qa_apivar where apivar_deleted_flag = 0 and apivar_inputflag =1 and api_id = ? ";
        List<ApiVarBean>  lists=jdbcTemplate.query(sql,new ApiVarBeanRowMapper(),taskid);
        return lists;

    }

    @Override
    public List<ApiVarBean> CheckAllVar(int taskid) {
        String sql= "select apivar_id,api_id,apivar_name,apivar_inputflag,apivar_inputdatatype,apivar_inputdatatypeid,apivar_inputlength,apivar_inputscope,apivar_inputnote,apivar_createdt,apivar_updatedt\n" +
                "from qa_apivar where apivar_deleted_flag = 0 and api_id = ?";
        List<ApiVarBean>  lists=jdbcTemplate.query(sql,new ApiVarBeanRowMapper(),taskid);
        return lists;
    }


}
