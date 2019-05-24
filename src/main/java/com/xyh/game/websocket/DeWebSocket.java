package com.xyh.game.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/ws/de")
public class DeWebSocket {

}