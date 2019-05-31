package com.xyh.game.websocket;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@Component
@ServerEndpoint(value = "/ws/de")
public class DeWebSocket {
    private Logger logger = LoggerFactory.getLogger(DeWebSocket.class);
    private Session session;
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
/*     private static int onlineCount = 0;
   //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //接收sid
    private String sid="";*/
    /**
     * 连接建立成功调用的方法*/
    @OnOpen
    public void onOpen(Session session) {
/*        this.session = session;
        webSocketSet.add(this);     //加入set中
        addOnlineCount();           //在线数加1
        log.info("有新窗口开始监听:"+sid+",当前在线人数为" + getOnlineCount());
        this.sid=sid;
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        }*/
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
           logger.info("onopenerror:",e);
        }
        logger.info("onopen");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
/*        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());*/
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
/*        log.info("收到来自窗口"+sid+"的信息:"+message);
        //群发消息
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        logger.info(message);
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
/*        log.error("发生错误");
        error.printStackTrace();*/
    }
    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }


}