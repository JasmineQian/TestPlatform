package com.example.demo.bean;

public class ApiCaseBean {

    private int apiCase_num;
    private int apiCase_pid;
    private String apiCase_projectname;
    private int apiCase_taskid;
    private String  apiCase_taskname;
    private String apiCase_name;
    private String apiCase_body;
    private String apiCase_asseertion;
    private String apiCase_priority;
    private int apiCase_priorityid;
    private int apiCase_passid;
    private String apiCase_passinfo;
    private int apiCase_deleteflag;
    private String apiCase_memo;
    private String createdt;
    private String updatedt;
    private int casetype_id;

    public String getApiCase_taskname() {
        return apiCase_taskname;
    }

    public void setApiCase_taskname(String apiCase_taskname) {
        this.apiCase_taskname = apiCase_taskname;
    }

    public int getApiCase_num() {
        return apiCase_num;
    }

    public void setApiCase_num(int apiCase_num) {
        this.apiCase_num = apiCase_num;
    }

    public int getApiCase_taskid() {
        return apiCase_taskid;
    }

    public void setApiCase_taskid(int apiCase_taskid) {
        this.apiCase_taskid = apiCase_taskid;
    }

    public String getApiCase_name() {
        return apiCase_name;
    }

    public void setApiCase_name(String apiCase_name) {
        this.apiCase_name = apiCase_name;
    }

    public String getApiCase_body() {
        return apiCase_body;
    }

    public void setApiCase_body(String apiCase_body) {
        this.apiCase_body = apiCase_body;
    }

    public String getApiCase_asseertion() {
        return apiCase_asseertion;
    }

    public void setApiCase_asseertion(String apiCase_asseertion) {
        this.apiCase_asseertion = apiCase_asseertion;
    }

    public String getApiCase_priority() {
        return apiCase_priority;
    }

    public void setApiCase_priority(String apiCase_priority) {
        this.apiCase_priority = apiCase_priority;
    }

    public int getApiCase_priorityid() {
        return apiCase_priorityid;
    }

    public void setApiCase_priorityid(int apiCase_priorityid) {
        this.apiCase_priorityid = apiCase_priorityid;
    }

    public int getApiCase_passid() {
        return apiCase_passid;
    }

    public void setApiCase_passid(int apiCase_passid) {
        this.apiCase_passid = apiCase_passid;
    }

    public String getApiCase_passinfo() {
        return apiCase_passinfo;
    }

    public void setApiCase_passinfo(String apiCase_passinfo) {
        this.apiCase_passinfo = apiCase_passinfo;
    }

    public String getCreatedt() {
        return createdt;
    }

    public void setCreatedt(String createdt) {
        this.createdt = createdt;
    }

    public String getUpdatedt() {
        return updatedt;
    }

    public void setUpdatedt(String updatedt) {
        this.updatedt = updatedt;
    }

    public int getApiCase_deleteflag() {
        return apiCase_deleteflag;
    }

    public void setApiCase_deleteflag(int apiCase_deleteflag) {
        this.apiCase_deleteflag = apiCase_deleteflag;
    }

    public String getApiCase_memo() {
        return apiCase_memo;
    }

    public void setApiCase_memo(String apiCase_memo) {
        this.apiCase_memo = apiCase_memo;
    }

    public int getApiCase_pid() {
        return apiCase_pid;
    }

    public void setApiCase_pid(int apiCase_pid) {
        this.apiCase_pid = apiCase_pid;
    }

    public String getApiCase_projectname() {
        return apiCase_projectname;
    }

    public void setApiCase_projectname(String apiCase_projectname) {
        this.apiCase_projectname = apiCase_projectname;
    }

    public int getCasetype_id() {return casetype_id;}

    public void setCasetype_id(int casetype_id) {
        this.casetype_id = casetype_id;
    }

    @Override
    public String toString() {
        return "ApiCaseBean{" +
                "apiCase_num=" + apiCase_num +
                ", apiCase_pid=" + apiCase_pid +
                ", apiCase_projectname='" + apiCase_projectname + '\'' +
                ", apiCase_taskid=" + apiCase_taskid +
                ", apiCase_taskname='" + apiCase_taskname + '\'' +
                ", apiCase_name='" + apiCase_name + '\'' +
                ", apiCase_body='" + apiCase_body + '\'' +
                ", apiCase_asseertion='" + apiCase_asseertion + '\'' +
                ", apiCase_priority='" + apiCase_priority + '\'' +
                ", apiCase_priorityid=" + apiCase_priorityid +
                ", apiCase_passid=" + apiCase_passid +
                ", apiCase_passinfo='" + apiCase_passinfo + '\'' +
                ", apiCase_deleteflag=" + apiCase_deleteflag +
                ", apiCase_memo='" + apiCase_memo + '\'' +
                ", createdt='" + createdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                ", casetype_id=" + casetype_id +
                '}';
    }
}
