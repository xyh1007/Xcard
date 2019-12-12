package com.xyh.game.res;

import java.io.Serializable;

public class ResResultEntity implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -7864957568015378909L;
	private int code = -1;
    private String message;

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
}
