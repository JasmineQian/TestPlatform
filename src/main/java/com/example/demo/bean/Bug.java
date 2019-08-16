package com.example.demo.bean;


public class Bug {

    private long id;

    private String pname;
    private String crname;
    private String crnum;
    private String tasknum;
    private String oname;
    private String description;
    private String rca;
    private String solution;
    private String tracking;
    private String developer;
    private String tester;
    private String creationdt;
    private String updatedt;
    private String bugStatus;

    public String getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(String bugStatus) {
        this.bugStatus = bugStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCrname() {
        return crname;
    }

    public void setCrname(String crname) {
        this.crname = crname;
    }

    public String getCrnum() {
        return crnum;
    }

    public void setCrnum(String crnum) {
        this.crnum = crnum;
    }

    public String getTasknum() {
        return tasknum;
    }

    public void setTasknum(String tasknum) {
        this.tasknum = tasknum;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRca() {
        return rca;
    }

    public void setRca(String rca) {
        this.rca = rca;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
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

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public Bug() {
        super();
    }

    public Bug(long id, String pname, String crname, String crnum, String tasknum, String oname, String description, String rca, String solution, String tracking, String developer, String tester, String creationdt, String updatedt, String bugStatus) {
        this.id = id;
        this.pname = pname;
        this.crname = crname;
        this.crnum = crnum;
        this.tasknum = tasknum;
        this.oname = oname;
        this.description = description;
        this.rca = rca;
        this.solution = solution;
        this.tracking = tracking;
        this.developer = developer;
        this.tester = tester;
        this.creationdt = creationdt;
        this.updatedt = updatedt;
        this.bugStatus = bugStatus;
    }


    @Override
    public String toString() {
        return "Bug{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", crname='" + crname + '\'' +
                ", crnum='" + crnum + '\'' +
                ", tasknum='" + tasknum + '\'' +
                ", oname='" + oname + '\'' +
                ", description='" + description + '\'' +
                ", rca='" + rca + '\'' +
                ", solution='" + solution + '\'' +
                ", tracking='" + tracking + '\'' +
                ", developer='" + developer + '\'' +
                ", tester='" + tester + '\'' +
                ", creationdt='" + creationdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                ", bugStatus='" + bugStatus + '\'' +
                '}';
    }
}
