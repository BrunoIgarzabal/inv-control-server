package com.brunoIgarzabal.invcontrol.repositories;

import com.brunoIgarzabal.invcontrol.domain.users.User;
import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void itShouldReturnUserWhenCallWithEmail() {
        String email = "brunoigar@live.com";
        User user = repository.findByEmail(email);

        assertNotNull(user);
        assertEquals(email, user.getEmail());
    }

    @Test
    public void itShouldReturnUserWhenCallWithUsername() {
        String username = "brunoIgarzabal";
        User user = repository.findByUserName(username);

        assertNotNull(user);
        assertEquals(username, user.getUserName());
    }

    @Test
    public void itShouldCreateUserWhenCall() {
        User user = new User(
            null, "brunoigar@hotmail.com",
    "brunoOIgarzabal", "Bruno Oliveira", UserType.ADMIN, "12345678"
        );

        user = repository.save(user);
        assertNotNull(user);

        assertNotNull(repository.findByEmail(user.getEmail()));
    }

    @Test
    public void itShouldDeleteUserWhenCallWithId() {
        Long id = 1L;

        Optional<User> user = repository.findById(id);
        assertNotNull(user);

        repository.deleteById(id);
        Optional<User> userAux = repository.findById(id);
        assertEquals(Optional.empty(), userAux);
    }

}
