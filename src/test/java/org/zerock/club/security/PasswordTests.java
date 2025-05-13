package org.zerock.club.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {

        String password = "1111";

        String enPw = passwordEncoder.encode(password);

        System.out.println("enPw: " + enPw);

        boolean matchResult = passwordEncoder.matches(password, enPw);

        System.out.println("matchResult: " + matchResult);
    }

}

// $2a$10$b0gpE8J5cakG0zm/Q9jpQO8kWzOF5E.qRJz/9/8FMba.wXXT2E4.2
// $2a$10$0c7MlPGPOLfUM354XPxSvOjeE.W/h39aEBIGkosdPF.JlLK6lf3Re