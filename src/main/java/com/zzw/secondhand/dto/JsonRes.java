package com.zzw.secondhand.dto;

public class JsonRes {

    private Integer errCode;

    private String errMsg;

    private Object data;

    public JsonRes(Integer errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public JsonRes setErrCode(Integer errCode) {
        this.errCode = errCode;
        return this;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public JsonRes setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public JsonRes setData(Object data) {
        this.data = data;
        return this;
    }
}
