package com.emtodo.workbench.ws.server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * webservice服务的生命接口
 *
 * @author EM
 * @version [v1.0]
 * @date: Created in 2019/11/11 0011 下午 2:55
 */
@WebService(name = "CommonService", // 暴露服务名称
        targetNamespace = "http://emtodo.com/"// 命名空间,一般是接口的包名倒序
)
public interface CommonService {

    /**
     * 测试方法
     * @param name
     * @return
     */
    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String sayHello(@WebParam(name = "userName")String name);

    /**
     * 控制水表设备
     *      cmd:0-关 1-开
     * @param cmd
     * @return
     */
    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String controlWater(@WebParam(name = "cmd")Integer cmd);
}
