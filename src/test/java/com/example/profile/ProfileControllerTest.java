package com.example.profile;

import com.example.profile.controller.ProfileController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProfileControllerTest {
    @Autowired
    private ProfileController profileController;

    @Test
    void contextLoads() {
        assertThat(profileController).isNotNull();
    }
}
