package com.example.demo.bean;

public class CR {

    private long id;
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
