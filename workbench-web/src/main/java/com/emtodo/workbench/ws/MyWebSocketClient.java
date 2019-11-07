package com.emtodo.workbench.ws;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

/**
 * WebSocketClient实现类
 *
 * @author EM
 * @version [v1.0]
 * @date: Created in 2019/11/7 0007 上午 10:30
 */
@Slf4j
public class MyWebSocketClient extends WebSocketClient {

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        // TODO Auto-generated method stub
        log.info("------ MyWebSocket onOpen ------");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        // TODO Auto-generated method stub
        log.info("------ MyWebSocket onClose ------{}",arg1);
    }

    @Override
    public void onError(Exception arg0) {
        // TODO Auto-generated method stub
        log.info("------ MyWebSocket onError ------{}",arg0);
    }

    @Override
    public void onMessage(String arg0) {
        // TODO Auto-generated method stub
        log.info("-------- 接收到服务端数据： " + arg0 + "--------");
    }
}
