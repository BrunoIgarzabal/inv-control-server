package com.brunoIgarzabal.invcontrol.domain.users.dto;

import com.brunoIgarzabal.invcontrol.domain.users.User;
import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    private String email;
    private String userName;

    private Set<UserType> profiles = new HashSet<>();

    public UserDTO() {}

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.userName = user.getUserName();
        this.setProfiles(user.getProfiles());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setProfiles(Set<UserType> userTypes) {
        profiles = userTypes;
    }
}
