package com.codergeshu.security.springboot.model;

import lombok.Data;

/**
 * @Date: 2021/2/15 22:47
 * @author: Eric
 */
@Data
public class PermissionDto {
    private String id;
    private String code;
    private String description;
    private String url;
}
