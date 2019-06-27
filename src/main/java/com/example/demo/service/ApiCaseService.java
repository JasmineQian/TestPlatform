package com.example.demo.service;

import com.example.demo.bean.ApiCaseBean;

import java.util.List;

public interface ApiCaseService {

    int add(ApiCaseBean apiCaseBean);

    List<ApiCaseBean> findApiCaseById(int apiID);

    ApiCaseBean findApiCase(int id);

    int update(ApiCaseBean apiCaseBean);

    int deleteByTypeId(int id,int typeid);

    int delete(int id);

}
