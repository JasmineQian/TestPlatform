package com.example.demo.jdbc;

import com.example.demo.bean.ApiVarBean;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ApiVarBeanRowMapper implements RowMapper<ApiVarBean> {
    @Override
    public ApiVarBean mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int apivar_id = resultSet.getInt("apivar_id");
        int api_id = resultSet.getInt("api_id");
        String apivar_name = resultSet.getString("apivar_name");
        String apivar_sample = resultSet.getString("apivar_sample");
        int apivar_inputflag = resultSet.getInt("apivar_inputflag");
        String apivar_inputdatatype = resultSet.getString("apivar_inputdatatype");
        int apivar_inputtype = resultSet.getInt("apivar_inputdatatypeid");
        int apivar_inputlenght =resultSet.getInt("apivar_inputlength");
        String apivar_scope = resultSet.getString("apivar_inputscope");
        String apivar_inputnote =resultSet.getString("apivar_inputnote");
        String createdt = resultSet.getString("apivar_createdt");
        String updatedt = resultSet.getString("apivar_updatedt");

        ApiVarBean apiVarBean = new ApiVarBean();
        apiVarBean.setNum(apivar_id);
        apiVarBean.setVal(apivar_name);
        apiVarBean.setVal_sample(apivar_sample);
        apiVarBean.setInputFlag(apivar_inputflag);
        apiVarBean.setInputDataType(apivar_inputdatatype);
        apiVarBean.setInputTypeID(apivar_inputtype);
        apiVarBean.setInputLenght(apivar_inputlenght);
        apiVarBean.setInputNote(apivar_inputnote);

        return apiVarBean;


    }




}
