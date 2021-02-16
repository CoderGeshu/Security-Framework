package com.codergeshu.security.springmvc.dao;

import com.codergeshu.security.springmvc.database.UserDB;
import com.codergeshu.security.springmvc.model.User;

/**
 * @Date: 2021/1/26 22:25
 * @author: Eric
 */
public class UserDao {
    public static User getUserById(String id) {
        return UserDB.userMap.get(id);
    }
}
