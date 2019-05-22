package com.example.demo.service;

import com.example.demo.bean.Employ;

import java.util.List;

public interface EmployService {

    List<Employ> findTester();

    List<Employ> findDeveloper();
}
