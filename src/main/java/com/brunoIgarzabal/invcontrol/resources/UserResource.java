package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.users.User;
import com.brunoIgarzabal.invcontrol.domain.users.dto.CreateUserDTO;
import com.brunoIgarzabal.invcontrol.domain.users.dto.UpdateUserDTO;
import com.brunoIgarzabal.invcontrol.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "api/users")
@Api( tags = "Users")
public class UserResource extends BaseResource<User> {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateUserDTO userDTO) {
        User user = new User(
            null, userDTO.getEmail(), userDTO.getUserName(), userDTO.getFullName(), userDTO.getUserType(),
                passwordEncoder.encode(userDTO.getPassword())
        );

        user = service.insert(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody UpdateUserDTO userDTO, @PathVariable Long id) {
        User user = new User(
                null, userDTO.getEmail(), userDTO.getUserName(), userDTO.getFullName(), userDTO.getUserType(),
                passwordEncoder.encode(userDTO.getPassword())
        );

        user.setId(id);
        user = service.update(user, id);
        return ResponseEntity.noContent().build();
    }

}
