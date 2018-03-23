package com.wenqi.demo.domain;

public class Area {
    private Integer areaId;
    private String areaName;
    private Integer areaPriority;//优先级，越小越靠前

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", areaPriority=" + areaPriority +
                '}';
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setAreaPriority(Integer areaPriority) {
        this.areaPriority = areaPriority;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public Integer getAreaPriority() {
        return areaPriority;
    }
}
