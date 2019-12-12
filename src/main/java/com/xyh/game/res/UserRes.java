package com.xyh.game.res;

import java.io.Serializable;

public class UserRes extends ResResultEntity{

    private static final long serialVersionUID = -6076347574632644112L;
    private String username;
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
