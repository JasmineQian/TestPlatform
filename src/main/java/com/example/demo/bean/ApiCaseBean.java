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

    public String gettaskname() {
        return taskname;
    }

    public void settaskname(String taskname) {
        this.taskname = taskname;
    }

    public int getnum() {
        return num;
    }

    public void setnum(int num) {
        this.num = num;
    }

    public int gettaskid() {
        return taskid;
    }

    public void settaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getbody() {
        return body;
    }

    public void setbody(String body) {
        this.body = body;
    }

    public String getasseertion() {
        return asseertion;
    }

    public void setasseertion(String asseertion) {
        this.asseertion = asseertion;
    }

    public String getpriority() {
        return priority;
    }

    public void setpriority(String priority) {
        this.priority = priority;
    }

    public int getpriorityid() {
        return priorityid;
    }

    public void setpriorityid(int priorityid) {
        this.priorityid = priorityid;
    }

    public int getpassid() {
        return passid;
    }

    public void setpassid(int passid) {
        this.passid = passid;
    }

    public String getpassinfo() {
        return passinfo;
    }

    public void setpassinfo(String passinfo) {
        this.passinfo = passinfo;
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

    public int getdeleteflag() {
        return deleteflag;
    }

    public void setdeleteflag(int deleteflag) {
        this.deleteflag = deleteflag;
    }

    public String getmemo() {
        return memo;
    }

    public void setmemo(String memo) {
        this.memo = memo;
    }

    public int getpid() {
        return pid;
    }

    public void setpid(int pid) {
        this.pid = pid;
    }

    public String getprojectname() {
        return projectname;
    }

    public void setprojectname(String projectname) {
        this.projectname = projectname;
    }

    public int getCasetype_id() {return casetype_id;}

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
