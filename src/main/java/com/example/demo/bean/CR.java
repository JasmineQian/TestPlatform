package com.example.demo.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Case的实体类",description = "这是Case对象")
public class CR {

    @ApiModelProperty(value="CR的ID", example="1")
    private long id;

    @ApiModelProperty(value="CR的类型", example="内部不收费CR")
    private String name;

    public CR(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CR() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CR{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
