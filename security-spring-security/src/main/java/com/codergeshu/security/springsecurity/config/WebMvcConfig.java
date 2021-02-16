package com.codergeshu.security.springsecurity.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 此配置类相当于 spring-mvc.xml
 *
 * @Date: 2021/1/29 10:07
 * @author: Eric
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.codergeshu.security.springsecurity",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class WebMvcConfig implements WebMvcConfigurer {

    // 重写视图控制器方法，将 "/" 转到 Spring Security 提供的默认的登录页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }

}
