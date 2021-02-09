package com.codergeshu.security.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * @Date: 2021/1/26 22:01
 * @author: Eric
 */
@Data
@AllArgsConstructor
public class User {

    /**
     * 用户会话 id
     */
    public static final String SESSION_USER_KEY = "_user";

    /**
     * 用户基本信息
     */
    private String username;
    private String password;

    /**
     * 存储用户权限
     */
    private Set<String> authorities;

}
