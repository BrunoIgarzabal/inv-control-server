package com.brunoIgarzabal.invcontrol.security;

import com.brunoIgarzabal.invcontrol.domain.users.enums.UserType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSpringSecurity implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public Long getId() { return id; }

    public UserSpringSecurity() {}

    public UserSpringSecurity(Long id, String email, String password, Set<UserType> profiles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = profiles.stream()
                .map(x -> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toList());
    }

    public boolean hasRole(UserType userType) {
        return getAuthorities()
                .contains(new SimpleGrantedAuthority(userType.getDescription()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
