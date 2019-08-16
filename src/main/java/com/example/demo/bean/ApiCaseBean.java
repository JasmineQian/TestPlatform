package com.example.demo.bean;

public class ApiCaseBean {

    private int num;
    private int pid;
    private String projectname;
    private int taskid;
    private String  taskname;
    private String name;
    private String body;
    private String asseertion;
    private String priority;
    private int priorityid;
    private int passid;
    private String passinfo;
    private int deleteflag;
    private String memo;
    private String createdt;
    private String updatedt;
    private int casetype_id;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAsseertion() {
        return asseertion;
    }

    public void setAsseertion(String asseertion) {
        this.asseertion = asseertion;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getPriorityid() {
        return priorityid;
    }

    public void setPriorityid(int priorityid) {
        this.priorityid = priorityid;
    }

    public int getPassid() {
        return passid;
    }

    public void setPassid(int passid) {
        this.passid = passid;
    }

    public String getPassinfo() {
        return passinfo;
    }

    public void setPassinfo(String passinfo) {
        this.passinfo = passinfo;
    }

    public int getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(int deleteflag) {
        this.deleteflag = deleteflag;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
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

    public int getCasetype_id() {
        return casetype_id;
    }

    public void setCasetype_id(int casetype_id) {
        this.casetype_id = casetype_id;
    }


    @Override
    public String toString() {
        return "ApiCaseBean{" +
                "num=" + num +
                ", pid=" + pid +
                ", projectname='" + projectname + '\'' +
                ", taskid=" + taskid +
                ", taskname='" + taskname + '\'' +
                ", name='" + name + '\'' +
                ", body='" + body + '\'' +
                ", asseertion='" + asseertion + '\'' +
                ", priority='" + priority + '\'' +
                ", priorityid=" + priorityid +
                ", passid=" + passid +
                ", passinfo='" + passinfo + '\'' +
                ", deleteflag=" + deleteflag +
                ", memo='" + memo + '\'' +
                ", createdt='" + createdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                ", casetype_id=" + casetype_id +
                '}';
    }
}
