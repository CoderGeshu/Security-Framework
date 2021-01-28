package com.codergeshu.security.springmvc.controller;

import com.codergeshu.security.springmvc.model.AuthenticationRequest;
import com.codergeshu.security.springmvc.model.User;
import com.codergeshu.security.springmvc.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Date: 2021/1/26 22:15
 * @author: Eric
 */
@RestController
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * 登入系统，进行身份认证，认证失败会抛出相应异常，成功则会保存用户信息在会话中，并返回成功信息
     *
     * @param authenticationRequest 认证请求
     * @param session               会话
     * @return 登入成功信息
     */
    @PostMapping(value = "/login", produces = "text/plain;charset=utf-8")
    public String validate(AuthenticationRequest authenticationRequest, HttpSession session) {
        User user = authenticationService.authentication(authenticationRequest);
        session.setAttribute(User.SESSION_USER_KEY, user);
        return user.getUsername() + " 登录成功";
    }

    /**
     * 退出系统，清理 session 存储
     *
     * @param session 会话存储对象
     * @return 退出成功信息
     */
    @GetMapping(value = "/logout", produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session) {
        session.invalidate();
        return "成功退出系统";
    }


    /**
     * 测试资源一
     *
     * @param session 会话对象
     * @return 用户访问资源一结果
     */
    @GetMapping(value = "/resource/r1", produces = "text/plain;charset=utf-8")
    public String resource1(HttpSession session) {
        String username;
        Object obj = session.getAttribute(User.SESSION_USER_KEY);
        // 由于添加了拦截器，所以执行此方法时用户一定存在，不再存在匿名访问的情况
        if (obj != null) {
            username = ((User) obj).getUsername();
        } else {
            username = "匿名";
        }
        return username + " 访问资源一";
    }

    /**
     * 测试资源二
     *
     * @param session 会话对象
     * @return 用户访问资源二结果
     */
    @GetMapping(value = "/resource/r2", produces = "text/plain;charset=utf-8")
    public String resource2(HttpSession session) {
        String username;
        Object obj = session.getAttribute(User.SESSION_USER_KEY);
        // 由于添加了拦截器，所以执行此方法时用户一定存在，不再存在匿名访问的情况
        if (obj != null) {
            username = ((User) obj).getUsername();
        } else {
            username = "匿名";
        }
        return username + " 访问资源二";
    }

}
