package com.emtodo.workbench.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *    首页访问
 * </p>
 * @author ：EM
 * @date ：Created in 2019/7/7
 * @version : V1.0
 */
@RestController
@Slf4j
public class IndexController {

    @RequestMapping("/workbench/index")
    public String index(){
        return "connect success!!!";
    }

    @RequestMapping("/workbench/list")
    public String list(){
        log.trace("==============trace log=================");
        log.info("==============info log=================");
        log.debug("==============debug log=================");
        log.warn("==============warn log=================");
        log.error("==============error log=================");

        try {
            int a = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            //log.error("异常了,简单错误为"+ExceptionUtil());
        }
        return "connect success!!!";
    }

}
