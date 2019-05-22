package com.example.demo.service;

import com.example.demo.bean.ApiInfoBean;

import java.util.List;

public interface ApiInfoService {

    List<ApiInfoBean> findAllApi(int pageon, int pid,String apiname);

    int countAll(int pageon, int pid,String apiname);

    ApiInfoBean findApiById(int id);

    int createApi(ApiInfoBean apiInfoBean);

    int updateApi(ApiInfoBean apiInfoBean);

    int deleteApi(int id);
}
