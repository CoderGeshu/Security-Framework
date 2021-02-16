package com.codergeshu.security.springsecurity.init;

import com.codergeshu.security.springsecurity.config.ApplicationConfig;
import com.codergeshu.security.springsecurity.config.WebMvcConfig;
import com.codergeshu.security.springsecurity.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 加载 Spring 容器，相当于传统 Spring mvc 项目中的 web.xml 的配置
 *
 * @Date: 2021/1/29 10:15
 * @author: Eric
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 指定 rootContext 的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class, WebSecurityConfig.class};
    }

    //指定 servletContext 的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcConfig.class};
    }

    // 设定映射
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
