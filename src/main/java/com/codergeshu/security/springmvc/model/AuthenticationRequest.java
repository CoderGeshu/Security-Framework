package com.codergeshu.security.springmvc.model;

import lombok.Data;

/**
 * 认证请求
 *
 * @Date: 2021/1/26 22:01
 * @author: Eric
 */
@Data
public class AuthenticationRequest {
    /**
     * 用户 ID
     */
    private String id;
    /**
     * 密码
     */
    private String password;
}
