package com.example.demo.service;

import com.example.demo.bean.Task;

import java.util.List;

public interface TaskService {


    List<Task> findAll();

    List<Task> findMultiByCondtion(int pageon,int pid,String name,String description);

    int countAll(int pageon,int pid,String name,String description);

    Task findById(int id);

    int create(Task task);

    int update(Task task);

    int deleteByID(int id);
}
