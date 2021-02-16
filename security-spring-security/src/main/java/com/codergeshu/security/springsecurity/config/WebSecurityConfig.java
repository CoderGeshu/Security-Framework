package com.codergeshu.security.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Date: 2021/1/29 10:10
 * @author: Eric
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 定义用户信息服务（用户详细信息）
     *
     * @return 用户详细信息
     */
    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("CoderGeshu").password("123456").authorities("p1").build());
        userDetailsManager.createUser(User.withUsername("Eric").password("456789").authorities("p2").build());
        return userDetailsManager;
    }

    /**
     * 定义密码编码器
     *
     * @return 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 定义安全拦截机制，最重要，类似于配置拦截器
     *
     * @param http http安全
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // HttpSecurity 的配置
        http.authorizeRequests()
                .antMatchers("/resource/r1").hasAuthority("p1")  // p1 权限可以访问resource1
                .antMatchers("/resource/r2").hasAuthority("p2")  // p2 权限可以访问resource2
                .antMatchers("/resource/**").authenticated() // 所有/resource/**请求必须认证通过
                .anyRequest().permitAll() // 除了/resource/**，其它的请求都可以访问
                .and()
                .formLogin().successForwardUrl("/login-success"); // 允许表单登录，成功后返回到指定URL
    }

}
