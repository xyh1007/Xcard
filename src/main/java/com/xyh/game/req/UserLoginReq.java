package com.xyh.game.req;

import java.io.Serializable;

public class UserLoginReq implements Serializable {

    private static final long serialVersionUID = -2432389741141053394L;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
