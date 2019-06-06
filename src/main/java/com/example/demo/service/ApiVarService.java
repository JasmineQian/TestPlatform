package com.example.demo.service;

import com.example.demo.bean.ApiVarBean;

import java.util.List;

public interface ApiVarService {

    int save(ApiVarBean apiVarBean);

    int saveall(List<ApiVarBean> apiVarBeanList);

    int update(ApiVarBean apiVarBean);

    int deleteByid(int id);

    ApiVarBean selectByid(int id);


    //查询出必传的入参，进行一次缺一个的遍历
    List<ApiVarBean> CheckMustVar(int taskid);

    //查询出所有的入参
    List<ApiVarBean> CheckAllVar(int taskid);

}
