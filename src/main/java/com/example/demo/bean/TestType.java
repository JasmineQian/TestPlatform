package com.example.demo.bean;

public class TestType {

    private long id;
    private String name;

    public TestType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TestType() {
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
        return "TestType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
