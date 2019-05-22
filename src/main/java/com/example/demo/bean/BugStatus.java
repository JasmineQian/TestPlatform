package com.example.demo.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Bug状态的实体类",description = "这是BugStatus对象")
public class BugStatus {

    @ApiModelProperty(value="Bug的ID", example="1")
    private int bugid;

    @ApiModelProperty(value="Bug的状态", example="关闭")
    private String bugStatus;

    public int getBugid() {
        return bugid;
    }

    public void setBugid(int bugid) {
        this.bugid = bugid;
    }

    public String getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(String bugStatus) {
        this.bugStatus = bugStatus;
    }
}
