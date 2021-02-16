package com.codergeshu.security.springmvc.init;

import com.codergeshu.security.springmvc.config.ApplicationConfig;
import com.codergeshu.security.springmvc.config.WebMvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 加载 Spring 容器，相当于传统 Spring mvc 项目中的 web.xml 的配置
 *
 * @Date: 2021/1/26 21:41
 * @author: Eric
 */
public class SpringApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 指定 rootContext 的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConfig.class};
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
