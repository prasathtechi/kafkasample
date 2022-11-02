package com.example.SpringCrudExample.response;

public class ErrorResponse {
    private String stausCode;

    public String getStausCode() {
        return stausCode;
    }

    public void setStausCode(String stausCode) {
        this.stausCode = stausCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private String errorMsg;

}
