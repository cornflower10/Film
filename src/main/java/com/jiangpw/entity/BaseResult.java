package com.jiangpw.entity;

public class BaseResult<T> {

    private boolean success;
    private String code;
    private String msg;
    private T data;

    public BaseResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public BaseResult(String code,boolean success, String msg) {
        this.success = success;
        this.msg = msg;
        this.code = code;
    }

    public BaseResult( T t) {
        this.data = t;
        this.success = true;
        this.msg = msg;
        this.code = "0000";
    }

    public BaseResult() {
//        super();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
