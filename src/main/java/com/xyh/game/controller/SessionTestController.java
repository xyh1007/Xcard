package com.xyh.game.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionTestController {
    @RequestMapping("/set")
    public Map<String,Object> first(HttpServletRequest request){
        request.getSession().setAttribute("testkey","testvalue");
        Map<String,Object> map = new HashMap<>();
        map.put("testkey","testvalue");
        return map;
    }

    @RequestMapping("/query")
    public Map<String,Object> second(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("sessionId",request.getSession().getId());
        map.put("testkey",request.getSession().getAttribute("testkey"));
        return map;
    }
}
