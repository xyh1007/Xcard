package com.xyh.game.res;

import lombok.Data;

import java.io.Serializable;


public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private T dataBody;

    public Result(int code, String message, T dataBody) {
        this.code = code;
        this.message = message;
        this.dataBody = dataBody;
    }

    public Result() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDataBody() {
        return dataBody;
    }

    public void setDataBody(T dataBody) {
        this.dataBody = dataBody;
    }
}
