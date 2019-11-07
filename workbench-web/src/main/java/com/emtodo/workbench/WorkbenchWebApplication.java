package com.emtodo.workbench;

import com.emtodo.workbench.ws.MyWebSocketClient;
import org.java_websocket.client.WebSocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * <p>
 *     workbench 工作台启动类
 * </p>
 * @author ：EM
 * @date ：Created in 2019/7/7
 * @version : V1.0
 */
@SpringBootApplication
public class WorkbenchWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkbenchWebApplication.class, args);
    }

    @Bean
    public WebSocketClient webSocketClient() {
        try {
            MyWebSocketClient webSocketClient = new MyWebSocketClient(new URI("ws://192.168.0.189:8080/websocket-demo/websocket/"+System.currentTimeMillis()));
            webSocketClient.connect();
            return webSocketClient;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
