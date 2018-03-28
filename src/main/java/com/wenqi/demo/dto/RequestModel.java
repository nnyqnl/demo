package com.wenqi.demo.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class RequestModel implements Serializable{
    private String offset;
    private String limit;
    private Map params = new HashMap<>();//多个参数

    @Override
    public String toString() {
        return "RequestModel{" +
                "offset='" + offset + '\'' +
                ", limit='" + limit + '\'' +
                ", params=" + params +
                '}';
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }
}
