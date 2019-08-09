package com.example.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Case的实体类",description = "这是Case对象")
public class Case {

    @ApiModelProperty(value="Bug的ID", example="1")
    private int id;


    @ApiModelProperty(value="Case的任务ID", example="1")
    private int taskid;

    @ApiModelProperty(value="Case的任务名称", example="1")
    private String taskname;

    @ApiModelProperty(value="Case的序号", example="1")
    private int num;

    @ApiModelProperty(value="Case的优先级", example="1")
    private int pirority;
    private String piroritymemo;

    @ApiModelProperty(value="Case的名称", example="1")
    private String name;

    @ApiModelProperty(value="Case的BODY", example="1")
    private String precondition;

    @ApiModelProperty(value="Case的BODY", example="1")
    private String body;

    @ApiModelProperty(value="Case的断言", example="1")
    private String assertion;

    @ApiModelProperty(value="Case是否通过标记", example="1")
    private int pass_flag;
    private String pass_memo;

    @ApiModelProperty(value="Case的描述")
    private String memo;

    @ApiModelProperty(value="创建时间")
    private String creationdt;

    @ApiModelProperty(value="更新时间")
    private String updatedt;

    public String gettaskname() {
        return taskname;
    }

    public void settaskname(String taskname) {
        this.taskname = taskname;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int gettaskid() {
        return taskid;
    }

    public void settaskid(int taskid) {
        this.taskid = taskid;
    }

    public int getnum() {
        return num;
    }

    public void setnum(int num) {
        this.num = num;
    }

    public int getpirority() {
        return pirority;
    }

    public void setpirority(int pirority) {
        this.pirority = pirority;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getprecondition() {
        return precondition;
    }

    public void setprecondition(String precondition) {
        this.precondition = precondition;
    }

    public String getbody() {
        return body;
    }

    public void setbody(String body) {
        this.body = body;
    }

    public String getassertion() {
        return assertion;
    }

    public void setassertion(String assertion) {
        this.assertion = assertion;
    }

    public int getpass_flag() {
        return pass_flag;
    }

    public void setpass_flag(int pass_flag) {
        this.pass_flag = pass_flag;
    }

    public String getmemo() {
        return memo;
    }

    public void setmemo(String memo) {
        this.memo = memo;
    }

    public String getCreationdt() {
        return creationdt;
    }

    public void setCreationdt(String creationdt) {
        this.creationdt = creationdt;
    }

    public String getUpdatedt() {
        return updatedt;
    }

    public void setUpdatedt(String updatedt) {
        this.updatedt = updatedt;
    }

    public String getpiroritymemo() {
        return piroritymemo;
    }

    public void setpiroritymemo(String piroritymemo) {
        this.piroritymemo = piroritymemo;
    }

    public String getpass_memo() {
        return pass_memo;
    }

    public void setpass_memo(String pass_memo) {
        this.pass_memo = pass_memo;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", taskid=" + taskid +
                ", taskname='" + taskname + '\'' +
                ", num=" + num +
                ", pirority=" + pirority +
                ", name='" + name + '\'' +
                ", precondition='" + precondition + '\'' +
                ", body='" + body + '\'' +
                ", assertion='" + assertion + '\'' +
                ", pass_flag=" + pass_flag +
                ", memo='" + memo + '\'' +
                ", creationdt='" + creationdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                '}';
    }
}
