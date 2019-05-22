package com.example.demo.bean;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel(value="查询结果的实体类",description = "这是SearchResult对象")
public class SearchResult {

    private List<Bug> list;
    private int count;

    public List<Bug> getList(List<Bug> bugs) {
        return list;
    }


    public int getCount(int count) {
        return this.count;
    }

    public List<Bug> getList() {
        return list;
    }

    public void setList(List<Bug> list) {
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
