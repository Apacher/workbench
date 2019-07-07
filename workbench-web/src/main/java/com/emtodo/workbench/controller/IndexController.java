package com.emtodo.workbench.controller;

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
public class IndexController {

    @RequestMapping("/workbench/index")
    public String index(){
        return "connect success!!!";
    }
}
