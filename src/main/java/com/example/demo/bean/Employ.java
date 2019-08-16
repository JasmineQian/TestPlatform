package com.example.demo.bean;

public class Employ {

    private long eid;
    private String ename;

    public Employ(long eid, String ename) {
        this.eid = eid;
        this.ename = ename;
    }

    public Employ()  {
        super();
    }

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                '}';
    }


}
