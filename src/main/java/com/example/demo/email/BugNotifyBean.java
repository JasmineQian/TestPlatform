package com.example.demo.email;

public class BugNotifyBean {

    private long id;
    private String pname;
    private String crname;
    private String crnum;
    private String tasknum;
    private String oname;
    private String description;
    private String rca;
    private String solution;
    private String developerEmail;
    private String testerEmail;
    private String creationdt;
    private String updatedt;
    private String bugStatus;

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

    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }

    public String getTesterEmail() {
        return testerEmail;
    }

    public void setTesterEmail(String testerEmail) {
        this.testerEmail = testerEmail;
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

    public String getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(String bugStatus) {
        this.bugStatus = bugStatus;
    }

    @Override
    public String toString() {
        return "BugNotifyBean{" +
                "id=" + id +
                ", pname='" + pname + '\'' +
                ", crname='" + crname + '\'' +
                ", crnum='" + crnum + '\'' +
                ", tasknum='" + tasknum + '\'' +
                ", oname='" + oname + '\'' +
                ", description='" + description + '\'' +
                ", rca='" + rca + '\'' +
                ", solution='" + solution + '\'' +
                ", developerEmail='" + developerEmail + '\'' +
                ", testerEmail='" + testerEmail + '\'' +
                ", creationdt='" + creationdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                ", bugStatus='" + bugStatus + '\'' +
                '}';
    }
}
