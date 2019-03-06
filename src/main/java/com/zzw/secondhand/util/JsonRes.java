package com.zzw.secondhand.util;

public class JsonRes<T> {

    private Integer errCode;

    private String errMsg;

    private T data;

    public JsonRes(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public JsonRes<T> setErrCode(Integer errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public JsonRes<T> setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public T getData() {
        return data;
    }

    public JsonRes<T> setData(T data) {
        this.data = data;
        return this;
    }
}
