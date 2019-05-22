package com.example.demo.bean;

import io.swagger.annotations.ApiModelProperty;

public class CaseProirity {

    @ApiModelProperty(value="测试用例等级的ID", example="1")
    private long id;

    @ApiModelProperty(value="测试用例等级的描述", example="高")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CaseProirityRowMapper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
