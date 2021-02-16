package com.codergeshu.security.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class SecuritySpringbootApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(BCrypt.hashpw("456789",BCrypt.gensalt()));
    }

}
