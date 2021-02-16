package com.codergeshu.security.springboot.service;

import com.codergeshu.security.springboot.dao.UserDao;
import com.codergeshu.security.springboot.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 实现 UserDetailsService，定义获取用户信息的具体途径
 *
 * @Date: 2021/2/1 22:19
 * @author: Eric
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {


    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username=" + username);
        UserDto user = userDao.getUserByUsername(username);
        if (user == null) {
            return null;
        }
        //查询用户权限
        List<String> permissions = userDao.findPermissionsByUserId(user.getId());
        String[] perArray = new String[permissions.size()];
        permissions.toArray(perArray);
        return User.withUsername(user.getUsername()).password(user.getPassword()).authorities(perArray).build();
    }
}
