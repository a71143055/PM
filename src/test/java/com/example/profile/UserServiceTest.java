package com.example.profile;

import com.example.profile.model.User;
import com.example.profile.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void testSaveUser() {
        User user = new User();
        user.setUsername("tester");
        user.setEmail("tester@example.com");
        user.setPassword("password");
        User saved = userService.save(user);
        assertThat(saved.getId()).isNotNull();
    }
}
