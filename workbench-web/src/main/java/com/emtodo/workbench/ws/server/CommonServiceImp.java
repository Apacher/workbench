package com.emtodo.workbench.ws.server;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.jws.WebService;

/**
 * webservice接口实现类
 *
 * @author EM
 * @version [v1.0]
 * @date: Created in 2019/11/11 0011 下午 2:59
 */

@WebService(serviceName = "CommonService", // 与接口中指定的name一致
        targetNamespace = "http://emtodo.com/", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.emtodo.workbench.ws.server.CommonService"// 接口地址
)
@Component
public class CommonServiceImp implements CommonService{

    @Override
    public String sayHello(String name) {
        return "Hello:::" + name;
    }

    @Override
    public String controlWater(Integer cmd) {
        if(StringUtils.isEmpty(cmd)){
            return "控制失败！！！";
        }
        if(0 == cmd){
            return "水表关闭成功！！！";
        }else if(1 == cmd){
            return "水表开启成功！！！";
        }else {
            return "无效的指令！！！";
        }
    }
}
