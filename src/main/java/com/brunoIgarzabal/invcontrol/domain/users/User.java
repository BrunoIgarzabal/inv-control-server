package com.brunoIgarzabal.invcontrol.domain.users;

import com.brunoIgarzabal.invcontrol.domain.Base;
import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "tb_users")
public final class User extends Base<User> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String userName;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "profiles")
    private Set<Integer> profiles = new HashSet<>();

    @JsonIgnore
    private String password;

    public User() {}

    public User(Long id, String email, String userName, String name, UserType userType, String password) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.name = name;
        addProfile(userType);
        this.password = password;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserType> getProfiles() {
        return profiles.stream()
                .map(x -> UserType.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(UserType userType) {
        profiles.add(userType.getCod());
    }

    public void setProfiles(Set<UserType> userTypes) {
        profiles = userTypes.stream()
                .map(x -> x.getCod()).collect(Collectors.toSet());
    }
}
