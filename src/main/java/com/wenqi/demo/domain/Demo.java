package com.wenqi.demo.domain;

public class Demo {
    private Integer id;
    private String status;
    private String type;
    private String other;
    private String demoTime;

    public String getDemoTime() {
        return demoTime;
    }

    public void setDemoTime(String demoTime) {
        this.demoTime = demoTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
