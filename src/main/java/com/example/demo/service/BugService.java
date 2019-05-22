package com.example.demo.service;


import com.example.demo.bean.Bug;
import java.util.List;


public interface BugService {

    List<Bug> findAllbyPage(int pageon, int pid,String crnum,String tasknum, int testerid, int devid);

    int countAll(int pid,String crnum,String tasknum, int testerid, int devid);

    Bug findById(int id);

    int create(Bug bug);

    int update(Bug bug);

/*
    int create(String pname, String crname, String crnum, String tasknum, String oname, String description, String rca, String solution, String developer, String tester,String bugStatus);

    int update(long id, String pname, String crname, String crnum, String tasknum, String oname, String description, String rca, String solution, String developer, String tester,String bugStatus);
*/

    int deleteByID(int id);


}
