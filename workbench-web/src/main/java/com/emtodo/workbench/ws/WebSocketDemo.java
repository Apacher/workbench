package com.emtodo.workbench.ws;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * //TODO
 *
 * @author EM
 * @version [v1.0]
 * @date: Created in 2019/11/7 0007 下午 7:00
 */
@ServerEndpoint("/websocket/{userId}")
public class WebSocketDemo {

    /**
     * 在线的客户端session集合，只在第一次new的时候初始化。
     */
    private static Map<String, Session> sessionMap=new HashMap<>();
    /**
     * 接收信息事件
     * @param message 客户端发来的消息
     * @param session 当前会话
     */
    @OnMessage
    public void onMessage(String message,Session session,@PathParam(value="userId")String userId)throws Exception {

        try {
            Iterator<String> it = sessionMap.keySet().iterator();
            //循环给每个客户端发送信息
            while(it.hasNext()){
                String key = (String) it.next();
                Session value = sessionMap.get(key);
                value.getBasicRemote().sendText(message);
            }
            System.out.println("用户"+userId+"说："+message+"。");
            System.out.println("当前在线人数："+sessionMap.size());
        } catch (Exception e) {
            System.out.println("接收消息事件异常!");
        }
    }

    /**
     * 打开连接事件
     * @throws Exception
     */
    @OnOpen
    public void onOpen(Session session,@PathParam(value="userId")String userId) throws Exception {
        System.out.println("打开连接成功！");
        sessionMap.put(userId, session);
        System.out.println("用户"+userId+"进来了。。。");
        System.out.println("当前在线人数："+sessionMap.size());
    }

    /**
     * 关闭连接事件
     */
    @OnClose
    public void onClose(Session session,@PathParam(value="userId")String userId) {
        System.out.println("关闭连接成功！");
        System.out.println("用户"+userId+"离开了。。。");
        sessionMap.remove(userId);
        System.out.println("当前在线人数："+sessionMap.size());
    }

    /**
     * 错误信息响应事件
     * @param session
     * @param throwable
     */
    @OnError
    public void OnError(Session session,Throwable throwable,@PathParam(value="userId")String userId) {
        System.out.println("异常："+throwable.getMessage());
        System.out.println("用户"+userId+"的连接出现了错误。。。");
        System.out.println("当前在线人数："+sessionMap.size());
    }
}
