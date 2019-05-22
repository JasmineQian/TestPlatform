package com.example.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Employ的实体类",description = "这是Employ对象")
public class Employ {

    @ApiModelProperty(value="Employ的ID", example="1")
    private long eid;

    @ApiModelProperty(value="Employ的名字", example="张三")
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
