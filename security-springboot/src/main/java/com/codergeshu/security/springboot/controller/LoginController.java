package com.codergeshu.security.springboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Date: 2021/1/29 10:31
 * @author: Eric
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success", produces = "text/plain;charset=utf-8")
    public String loginSuccess() {
        return getUsername() + " 登录成功";
    }

    /**
     * 测试资源1
     *
     * @return 访问结果
     */
    @GetMapping(value = "/resource/r1", produces = "text/plain;charset=utf-8")
    public String r1() {
        return getUsername() + " 访问资源1";
    }

    /**
     * 测试资源2
     *
     * @return 访问结果
     */
    @GetMapping(value = "/resource/r2", produces = "text/plain;charset=utf-8")
    public String r2() {
        return getUsername() + " 访问资源2";
    }


    /**
     * 获取当前认证的用户姓名
     *
     * @return 当前认证用户姓名字符串
     */
    private String getUsername() {
        String username = null;
        // 通过认证框架 API 获取当前认证通过的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 用户身份
        Object principal = authentication.getPrincipal();
        // 当没有登录时此身份为空
        if (principal == null) {
            username = "匿名";
        }
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

}
