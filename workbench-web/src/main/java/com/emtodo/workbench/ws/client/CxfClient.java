package com.emtodo.workbench.ws.client;

import com.emtodo.workbench.ws.server.ClientLoginInterceptor;
import com.emtodo.workbench.ws.server.CommonService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * webservice客户端测试调用
 *
 * @author EM
 * @version [v1.0]
 * @date: Created in 2019/11/11 0011 下午 3:40
 */
public class CxfClient {

    private static String USER_NAME="admin";
    private static String PASS_WORD="123456";
    public static void main(String[] args) {
        //cl1();
        System.out.println("---------------调用时加入用户名，密码认证--------------");
        cl2();
    }
    /**
     * 方式1.代理类工厂的方式,需要拿到对方的接口
     */
    public static void cl1() {
        try {
            // 接口地址
            String address = "http://localhost:9090/services/CommonService?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(CommonService.class);
            // 创建一个代理接口实现
            CommonService cs = (CommonService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String userName = "你好你好你好";
            // 调用代理接口的方法调用并返回结果
            String result = cs.sayHello(userName);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 动态调用方式
     */
    public static void cl2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8088/services/CommonService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("controlWater", 8);
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

}
