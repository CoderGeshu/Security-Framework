package com.codergeshu.security.springboot.dao;

import com.codergeshu.security.springboot.model.PermissionDto;
import com.codergeshu.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 2021/2/15 20:54
 * @author: Eric
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 根据用户名查询用户信息
    public UserDto getUserByUsername(String username) {
        String mysql = "select * from t_user where username = ?";
        List<UserDto> userDtos = jdbcTemplate.query(mysql, new Object[]{username}, new BeanPropertyRowMapper<>(UserDto.class));
        if (userDtos.size() == 1) {
            return userDtos.get(0);
        }
        return null;
    }

    // 根据用户 ID 查询用户权限
    public List<String> findPermissionsByUserId(String userId) {
        String mysql = "SELECT * FROM t_permission WHERE id IN(" +
                "SELECT permission_id FROM t_role_permission WHERE role_id IN(" +
                "SELECT role_id FROM t_user_role WHERE user_id = ? ))";
        List<PermissionDto> list = jdbcTemplate.query(mysql, new Object[]{userId}, new BeanPropertyRowMapper<>(PermissionDto.class));
        List<String> permissions = new ArrayList<>();
        list.iterator().forEachRemaining(c -> permissions.add(c.getCode()));
        return permissions;
    }

}
