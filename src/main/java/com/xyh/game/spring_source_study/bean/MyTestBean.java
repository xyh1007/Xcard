package com.xyh.game.spring_source_study.bean;

import java.util.HashMap;
import java.util.Map;

public class MyTestBean {
    private String str = "test";
    private Map<String,Object> map = new HashMap<>();

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
