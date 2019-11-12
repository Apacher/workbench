package com.emtodo.workbench.ws.server;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * webservice配置类
 *
 * @author EM
 * @version [v1.0]
 * @date: Created in 2019/11/11 0011 下午 3:02
 */
@Configuration
public class CXFConfig {

    @Autowired
    private Bus bus;

    @Autowired
    CommonService commonService;

    /**
     * 一定要有
     * @return
     */
    @Bean
    public ServletRegistrationBean cxfServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/services/*");
    }

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, commonService);
        endpoint.publish("/CommonService");
        endpoint.getInInterceptors().add(new ClientLoginInterceptor());
        endpoint.getInInterceptors().add(new AuthInterceptor());
        return endpoint;
    }
}
