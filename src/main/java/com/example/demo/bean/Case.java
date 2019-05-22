package com.example.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Case的实体类",description = "这是Case对象")
public class Case {

    @ApiModelProperty(value="Bug的ID", example="1")
    private int case_id;


    @ApiModelProperty(value="Case的任务ID", example="1")
    private int case_taskid;

    @ApiModelProperty(value="Case的任务名称", example="1")
    private String case_taskname;

    @ApiModelProperty(value="Case的序号", example="1")
    private int case_num;

    @ApiModelProperty(value="Case的优先级", example="1")
    private int case_pirority;
    private String case_piroritymemo;

    @ApiModelProperty(value="Case的名称", example="1")
    private String case_name;

    @ApiModelProperty(value="Case的BODY", example="1")
    private String case_precondition;

    @ApiModelProperty(value="Case的BODY", example="1")
    private String case_body;

    @ApiModelProperty(value="Case的断言", example="1")
    private String case_assertion;

    @ApiModelProperty(value="Case是否通过标记", example="1")
    private int case_pass_flag;
    private String case_pass_memo;

    @ApiModelProperty(value="Case的描述")
    private String case_memo;

    @ApiModelProperty(value="创建时间")
    private String creationdt;

    @ApiModelProperty(value="更新时间")
    private String updatedt;

    public String getCase_taskname() {
        return case_taskname;
    }

    public void setCase_taskname(String case_taskname) {
        this.case_taskname = case_taskname;
    }

    public int getCase_id() {
        return case_id;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public int getCase_taskid() {
        return case_taskid;
    }

    public void setCase_taskid(int case_taskid) {
        this.case_taskid = case_taskid;
    }

    public int getCase_num() {
        return case_num;
    }

    public void setCase_num(int case_num) {
        this.case_num = case_num;
    }

    public int getCase_pirority() {
        return case_pirority;
    }

    public void setCase_pirority(int case_pirority) {
        this.case_pirority = case_pirority;
    }

    public String getCase_name() {
        return case_name;
    }

    public void setCase_name(String case_name) {
        this.case_name = case_name;
    }

    public String getCase_precondition() {
        return case_precondition;
    }

    public void setCase_precondition(String case_precondition) {
        this.case_precondition = case_precondition;
    }

    public String getCase_body() {
        return case_body;
    }

    public void setCase_body(String case_body) {
        this.case_body = case_body;
    }

    public String getCase_assertion() {
        return case_assertion;
    }

    public void setCase_assertion(String case_assertion) {
        this.case_assertion = case_assertion;
    }

    public int getCase_pass_flag() {
        return case_pass_flag;
    }

    public void setCase_pass_flag(int case_pass_flag) {
        this.case_pass_flag = case_pass_flag;
    }

    public String getCase_memo() {
        return case_memo;
    }

    public void setCase_memo(String case_memo) {
        this.case_memo = case_memo;
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

    public String getCase_piroritymemo() {
        return case_piroritymemo;
    }

    public void setCase_piroritymemo(String case_piroritymemo) {
        this.case_piroritymemo = case_piroritymemo;
    }

    public String getCase_pass_memo() {
        return case_pass_memo;
    }

    public void setCase_pass_memo(String case_pass_memo) {
        this.case_pass_memo = case_pass_memo;
    }

    @Override
    public String toString() {
        return "Case{" +
                "case_id=" + case_id +
                ", case_taskid=" + case_taskid +
                ", case_taskname='" + case_taskname + '\'' +
                ", case_num=" + case_num +
                ", case_pirority=" + case_pirority +
                ", case_name='" + case_name + '\'' +
                ", case_precondition='" + case_precondition + '\'' +
                ", case_body='" + case_body + '\'' +
                ", case_assertion='" + case_assertion + '\'' +
                ", case_pass_flag=" + case_pass_flag +
                ", case_memo='" + case_memo + '\'' +
                ", creationdt='" + creationdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                '}';
    }
}
