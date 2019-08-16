package com.example.demo.bean;

public class ApiInfoBean {

    private int id;
    private int pid;
    private String projectname;
    private String name;
    private String hostname;
    private String path;
    private String memo;
    private String creatdt;
    private String updatedt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCreatdt() {
        return creatdt;
    }

    public void setCreatdt(String creatdt) {
        this.creatdt = creatdt;
    }

    public String getUpdatedt() {
        return updatedt;
    }

    public void setUpdatedt(String updatedt) {
        this.updatedt = updatedt;
    }

    @Override
    public String toString() {
        return "ApiInfoBean{" +
                "id=" + id +
                ", pid=" + pid +
                ", projectname='" + projectname + '\'' +
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
