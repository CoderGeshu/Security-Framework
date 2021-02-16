package com.codergeshu.security.springmvc.service;

import com.codergeshu.security.springmvc.dao.UserDao;
import com.codergeshu.security.springmvc.model.AuthenticationRequest;
import com.codergeshu.security.springmvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Date: 2021/1/26 22:03
 * @author: Eric
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public User authentication(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest == null
                || ObjectUtils.isEmpty(authenticationRequest.getId())
                || ObjectUtils.isEmpty(authenticationRequest.getPassword())) {
            throw new RuntimeException("账号或密码为空");
        }
        User user = UserDao.getUserById(authenticationRequest.getId());
        if (user == null) {
            throw new RuntimeException("查询不到该用户");
        }
        if (!user.getPassword().equals(authenticationRequest.getPassword())) {
            throw new RuntimeException("账号或密码错误");
        }
        return user;
    }

}
