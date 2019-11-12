package com.emtodo.workbench.ws.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.NodeList;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

/**
 * 发布服务端，定义拦截器用户用户验证 -> 服务端针对客户端请求时需要密码认证
 *
 * @author EM
 * @version [v1.0]
 * @date: Created in 2019/11/11 0011 下午 3:10
 */
@Slf4j
public class AuthInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

    private SAAJInInterceptor saa = new SAAJInInterceptor();
    private static final String USER_NAME = "admin";
    private static final String USER_PASSWORD = "123456";
    public AuthInterceptor() {
        super(Phase.PRE_PROTOCOL);
        getAfter().add(SAAJInInterceptor.class.getName());
    }
    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        SOAPMessage mess = message.getContent(SOAPMessage.class);
        if(mess==null){
            saa.handleMessage(message);
            mess=message.getContent(SOAPMessage.class);
        }
        SOAPHeader header =null;
        try {
            header = mess.getSOAPHeader();
        } catch (SOAPException e) {
            log.error("getSOAPheader error:{}",e.getMessage(),e);
            e.printStackTrace();
        }
        if(header==null){
            throw new Fault(new IllegalAccessException("找不到Header,无法验证用户信息"));
        }
        NodeList username = header.getElementsByTagName("username");
        NodeList password = header.getElementsByTagName("password");
        if(username.getLength()<1){
            throw new Fault(new IllegalAccessException("找不到Header,无法验证用户信息"));
        }
        if(password.getLength()<1){
            throw new Fault(new IllegalAccessException("找不到Header,无法验证用户信息"));
        }
        String userName = username.item(0).getTextContent().trim();
        String passWord = password.item(0).getTextContent().trim();
        if(USER_NAME.equals(userName)&&USER_PASSWORD.equals(passWord)){
            log.info("admin auth success");
        }else {
            SOAPException soapException = new SOAPException("认证错误");
            log.error("admin auth failed");
            throw new Fault(soapException);
        }
    }
}
