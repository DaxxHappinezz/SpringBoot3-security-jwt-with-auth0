package com.example.springbootsecurityjwt.service;

import com.example.springbootsecurityjwt.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "test@test.com";
    private static final String ANOTHER_EMAIL = "next@test.com";

    public Optional<UserEntity> findByEmail(String email) {
        // TODO: Move this to a database
        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(1L);
            user.setEmail(email);
            user.setPassword("$2a$12$FKP6DKc6pb8B6FOX.EIXgeo0BOLu9WYpcO9GOKhBEmmqa8u1/SPuC"); // test
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("My nice ADMIN");
            return Optional.of(user);
        } else if (ANOTHER_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(99L);
            user.setEmail(email);
            user.setPassword("$2a$12$FKP6DKc6pb8B6FOX.EIXgeo0BOLu9WYpcO9GOKhBEmmqa8u1/SPuC"); // test
            user.setRole("ROLE_USER");
            user.setExtraInfo("My nice USER");
            return Optional.of(user);
        }

        return Optional.empty();
    }
}
