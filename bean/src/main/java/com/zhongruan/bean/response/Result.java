package com.zhongruan.bean.response;

import java.io.Serializable;

public class Result{
    private String message;
    private Object data;

    public Result() {
    }

    public Result(String message, Object data) {
        this.message = message;
        if(data == null){
            this.data = "";
        }else {
            this.data = data;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
