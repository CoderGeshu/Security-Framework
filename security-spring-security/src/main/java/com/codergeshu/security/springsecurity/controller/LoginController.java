package com.codergeshu.security.springsecurity.controller;

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
        return " 登录成功";
    }

    /**
     * 测试资源1
     *
     * @return 访问结果
     */
    @GetMapping(value = "/resource/r1", produces = "text/plain;charset=utf-8")
    public String r1() {
        return " 访问资源1";
    }

    /**
     * 测试资源2
     *
     * @return 访问结果
     */
    @GetMapping(value = "/resource/r2", produces = "text/plain;charset=utf-8")
    public String r2() {
        return " 访问资源2";
    }

}
