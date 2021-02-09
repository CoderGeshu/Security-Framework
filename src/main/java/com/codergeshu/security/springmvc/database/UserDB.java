package com.codergeshu.security.springmvc.database;

import com.codergeshu.security.springmvc.model.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 模拟数据库
 *
 * @Date: 2021/1/26 22:20
 * @author: Eric
 */
public class UserDB {

    public static Map<String, User> userMap;

    static {
        userMap = new HashMap<>();
        Set<String> authorities1 = new HashSet<>();
        authorities1.add("p1");
        Set<String> authorities2 = new HashSet<>();
        authorities2.add("p2");
        userMap.put("CoderGeshu", new User("CoderGeshu", "123456", authorities1));
        userMap.put("Eric", new User("Eric", "456789", authorities2));
    }
}
