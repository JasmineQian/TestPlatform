package com.example.demo.service;

import com.example.demo.bean.Case;

import java.util.List;

public interface CaseService {


    List<Case> findCasesbyTaskid(int id,int pageon);

    int countCasesbyTaskid(int id,int pageon);

    Case findById(int id);

    int create(Case testcase);

    int createList(List<Case> list);

    int update(Case testcase);

    int deleteByID(int id);
}
