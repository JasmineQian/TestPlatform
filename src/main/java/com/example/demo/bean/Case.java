package com.example.demo.bean;


public class Case {

    private int id;
    private int taskid;
    private String taskname;
    private int num;
    private int pirority;
    private String piroritymemo;
    private String name;
    private String precondition;
    private String body;
    private String assertion;
    private int pass_flag;
    private String pass_memo;
    private String memo;
    private String creationdt;
    private String updatedt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPirority() {
        return pirority;
    }

    public void setPirority(int pirority) {
        this.pirority = pirority;
    }

    public String getPiroritymemo() {
        return piroritymemo;
    }

    public void setPiroritymemo(String piroritymemo) {
        this.piroritymemo = piroritymemo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrecondition() {
        return precondition;
    }

    public void setPrecondition(String precondition) {
        this.precondition = precondition;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAssertion() {
        return assertion;
    }

    public void setAssertion(String assertion) {
        this.assertion = assertion;
    }

    public int getPass_flag() {
        return pass_flag;
    }

    public void setPass_flag(int pass_flag) {
        this.pass_flag = pass_flag;
    }

    public String getPass_memo() {
        return pass_memo;
    }

    public void setPass_memo(String pass_memo) {
        this.pass_memo = pass_memo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
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


    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", taskid=" + taskid +
                ", taskname='" + taskname + '\'' +
                ", num=" + num +
                ", pirority=" + pirority +
                ", piroritymemo='" + piroritymemo + '\'' +
                ", name='" + name + '\'' +
                ", precondition='" + precondition + '\'' +
                ", body='" + body + '\'' +
                ", assertion='" + assertion + '\'' +
                ", pass_flag=" + pass_flag +
                ", pass_memo='" + pass_memo + '\'' +
                ", memo='" + memo + '\'' +
                ", creationdt='" + creationdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                '}';
    }
}
