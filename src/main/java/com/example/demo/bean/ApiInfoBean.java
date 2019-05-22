package com.example.demo.bean;

public class ApiInfoBean {

    private int api_id;
    private int api_pid;
    private String api_porjectname;
    private String api_name;
    private String api_hostname;
    private String api_path;
    private String api_memo;
    private String api_creatdt;
    private String api_updatedt;

    public int getApi_id() {
        return api_id;
    }

    public void setApi_id(int api_id) {
        this.api_id = api_id;
    }

    public int getApi_pid() {
        return api_pid;
    }

    public void setApi_pid(int api_pid) {
        this.api_pid = api_pid;
    }

    public String getApi_porjectname() {
        return api_porjectname;
    }

    public void setApi_porjectname(String api_porjectname) {
        this.api_porjectname = api_porjectname;
    }

    public String getApi_name() {
        return api_name;
    }

    public void setApi_name(String api_name) {
        this.api_name = api_name;
    }

    public String getApi_hostname() {
        return api_hostname;
    }

    public void setApi_hostname(String api_hostname) {
        this.api_hostname = api_hostname;
    }

    public String getApi_path() {
        return api_path;
    }

    public void setApi_path(String api_path) {
        this.api_path = api_path;
    }

    public String getApi_memo() {
        return api_memo;
    }

    public void setApi_memo(String api_memo) {
        this.api_memo = api_memo;
    }

    public String getApi_creatdt() {
        return api_creatdt;
    }

    public void setApi_creatdt(String api_creatdt) {
        this.api_creatdt = api_creatdt;
    }

    public String getApi_updatedt() {
        return api_updatedt;
    }

    public void setApi_updatedt(String api_updatedt) {
        this.api_updatedt = api_updatedt;
    }

    @Override
    public String toString() {
        return "ApiInfoBean{" +
                "api_id=" + api_id +
                ", api_pid=" + api_pid +
                ", api_porjectname='" + api_porjectname + '\'' +
                ", api_name='" + api_name + '\'' +
                ", api_hostname='" + api_hostname + '\'' +
                ", api_path='" + api_path + '\'' +
                ", api_memo='" + api_memo + '\'' +
                ", api_creatdt='" + api_creatdt + '\'' +
                ", api_updatedt='" + api_updatedt + '\'' +
                '}';
    }


    public ApiInfoBean() {
        super();
    }
}
