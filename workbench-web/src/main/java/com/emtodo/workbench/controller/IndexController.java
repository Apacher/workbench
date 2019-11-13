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

        System.out.println("Hello brother!!!!");
        return "connect success!!!";
    }

    @RequestMapping("/workbench/list")
    public String list(){
        log.trace("==============trace log=================");
        log.info("==============info log=================");
        log.debug("==============debug log=================");
        log.warn("==============warn log=================");
        log.error("==============error log=================");

        int[] data = {1,2,3,4,5,6,7,8,9,2,3,4,5,6,3,2,3,4,5,2,1,2,3,4,5,6,3,2,1,2,3,4,5,2,1,2,3,4,5,3,2};

        try {
            int a = 1/0;
        } catch (Exception e) {
            e.printStackTrace();
            //log.error("异常了,简单错误为"+ExceptionUtil());
        }
        return "connect success!!!";
    }

}
