package com.brunoIgarzabal.invcontrol.repositories;

import com.brunoIgarzabal.invcontrol.domain.users.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void shouldReturnUserWhenCallWithEmail() {
        String email = "brunoigar@live.com";
        User user = repository.findByEmail(email);

        //assertNotNull(user);
        //assertEquals(email, user.getEmail());
    }
}
