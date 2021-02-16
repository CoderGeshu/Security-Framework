package com.codergeshu.security.springboot.model;

import lombok.Data;

/**
 * @Date: 2021/2/15 20:52
 * @author: Eric
 */
@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
}
