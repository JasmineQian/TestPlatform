package com.example.demo.bean;

public class Project {

    private long pid;
    private String pname;
    private String pcreationdt;
    private String pupdatedt;

    public Project() {
        super();
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPcreationdt() {
        return pcreationdt;
    }

    public void setPcreationdt(String pcreationdt) {
        this.pcreationdt = pcreationdt;
    }

    public String getPupdatedt() {
        return pupdatedt;
    }

    public void setPupdatedt(String pupdatedt) {
        this.pupdatedt = pupdatedt;
    }


    public Project(long pid, String pname, String pcreationdt, String pupdatedt) {
        this.pid = pid;
        this.pname = pname;
        this.pcreationdt = pcreationdt;
        this.pupdatedt = pupdatedt;
    }


    @Override
    public String toString() {
        return "Project{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pcreationdt='" + pcreationdt + '\'' +
                ", pupdatedt='" + pupdatedt + '\'' +
                '}';
    }
}
