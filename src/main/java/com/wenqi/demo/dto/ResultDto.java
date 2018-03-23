package com.wenqi.demo.dto;

public class ResultDto {
    private String code;
    private String msg;
    private Object data;

    public ResultDto() {
    }

    @Override
    public String toString() {
        return "ResultDto{" +
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

    public ResultDto(String code, String msg, Object data) {

        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
