package com.emtodo.workbench.controller;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WebSocket客户端类
 *
 * @author EM
 * @version [v1.0]
 * @date: Created in 2019/11/7 0007 上午 10:38
 */
@Slf4j
@RestController
public class WebSocketController {

    @Autowired
    private WebSocketClient webSocketClient;

    @RequestMapping("/subscribe")
    public String subscribe() {
        System.out.println("访问进来了！！！");
        // webSocketClient.connect();
        webSocketClient.send("hello sever，i want subscribe data A");
        return "发送订阅成功！！！";
    }

}
