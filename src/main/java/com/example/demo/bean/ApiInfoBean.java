package com.example.demo.bean;

public class ApiInfoBean {

    private int id;
    private int pid;
    private String porjectname;
    private String name;
    private String hostname;
    private String path;
    private String memo;
    private String creatdt;
    private String updatedt;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public int getpid() {
        return pid;
    }

    public void setpid(int pid) {
        this.pid = pid;
    }

    public String getporjectname() {
        return porjectname;
    }

    public void setporjectname(String porjectname) {
        this.porjectname = porjectname;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String gethostname() {
        return hostname;
    }

    public void sethostname(String hostname) {
        this.hostname = hostname;
    }

    public String getpath() {
        return path;
    }

    public void setpath(String path) {
        this.path = path;
    }

    public String getmemo() {
        return memo;
    }

    public void setmemo(String memo) {
        this.memo = memo;
    }

    public String getcreatdt() {
        return creatdt;
    }

    public void setcreatdt(String creatdt) {
        this.creatdt = creatdt;
    }

    public String getupdatedt() {
        return updatedt;
    }

    public void setupdatedt(String updatedt) {
        this.updatedt = updatedt;
    }

    @Override
    public String toString() {
        return "ApiInfoBean{" +
                "id=" + id +
                ", pid=" + pid +
                ", porjectname='" + porjectname + '\'' +
                ", name='" + name + '\'' +
                ", hostname='" + hostname + '\'' +
                ", path='" + path + '\'' +
                ", memo='" + memo + '\'' +
                ", creatdt='" + creatdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                '}';
    }


    public ApiInfoBean() {
        super();
    }
}
