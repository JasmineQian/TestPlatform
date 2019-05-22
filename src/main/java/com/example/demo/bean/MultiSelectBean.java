package com.example.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="MultiSelectBean的实体类",description = "这是Employ对象")
public class MultiSelectBean {

    @ApiModelProperty(value="多选条件中的项目的ID", example="1")
    private int pid;

    @ApiModelProperty(value="多选条件中的CR编号", example="1")
    private String crnum;

    @ApiModelProperty(value="多选条件中的Task编号", example="1")
    private String tasknum;

    @ApiModelProperty(value="多选条件中的测试人员的ID", example="1")
    private int testerid;

    @ApiModelProperty(value="多选条件中的开发人员的ID", example="1")
    private int devid;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getCrnum() {
        return crnum;
    }

    public void setCrnum(String crnum) {
        this.crnum = crnum;
    }

    public String getTasknum() {
        return tasknum;
    }

    public void setTasknum(String tasknum) {
        this.tasknum = tasknum;
    }

    public int getTesterid() {
        return testerid;
    }

    public void setTesterid(int testerid) {
        this.testerid = testerid;
    }

    public int getDevid() {
        return devid;
    }

    public void setDevid(int devid) {
        this.devid = devid;
    }
}
