package com.codergeshu.security.springsecurity.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 此配置类相当于 applicationContext.xml
 *
 * @Date: 2021/1/29 10:06
 * @author: Eric
 */
@Configuration
@ComponentScan(basePackages = "com.codergeshu.security.springsecurity",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {
    // 在此配置除了 Controller 的其它 bean，比如：数据库链接池、事务管理器、业务 bean 等。
}
