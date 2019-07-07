package com.emtodo.workbench;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <p>
 *     未知类
 * </p>
 * @author ：EM
 * @date ：Created in 2019/7/7
 * @version : V1.0
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WorkbenchWebApplication.class);
    }

}
