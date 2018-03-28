package com.wenqi.demo.dto;

public class ResultModel {
    private String code;
    private String msg;
    private Object data;//业务数据

    public ResultModel() {
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {

        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public ResultModel(String code, String msg, Object data) {

        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public ResultModel(String code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public ResultModel(Object data) {

        this.code = "200";
        this.msg = "ok";
        this.data = data;
    }
    public static ResultModel ok(Object data) {

        return new ResultModel(data);
    }
}
