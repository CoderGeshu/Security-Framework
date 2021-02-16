package com.codergeshu.security.springsecurity.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 配置 Spring Security 初始化
 *
 * @Date: 2021/1/29 10:25
 * @author: Eric
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    // 若当前环境没有使用Spring或Spring MVC，则需要将 WebSecurityConfig(Spring Security配置类) 传入超
    // 类，以确保获取配置，并创建spring context。
    // 相反，若当前环境已经使用spring，我们应该在现有的springContext中注册Spring Security(在SpringApplicationInitializer
    // 中已经配置)，此方法可以什么都不做。
    public SpringSecurityApplicationInitializer() {
        //super(WebSecurityConfig.class);
    }

}
