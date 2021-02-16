package com.codergeshu.security.springmvc.service;

import com.codergeshu.security.springmvc.model.AuthenticationRequest;
import com.codergeshu.security.springmvc.model.User;

/**
 * 提供认证服务
 *
 * @Date: 2021/1/26 21:59
 * @author: Eric
 */
public interface AuthenticationService {
    /**
     * 用户认证
     *
     * @param authenticationRequest 用户认证请求，账号和密码
     * @return 认证成功的用户信息
     */
    User authentication(AuthenticationRequest authenticationRequest);
}
