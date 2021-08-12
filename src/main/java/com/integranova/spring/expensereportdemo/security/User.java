package com.integranova.spring.expensereportdemo.security;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

    private static final long serialVersionUID = -666934482283692554L;

    private String id;
    private String username;
    private String password;
    private Collection<SimpleGrantedAuthority> authorities;

    public User() {
        super();
    }

    public User(final String username, final String password, List<String> roles) {
        super();
        this.id = requireNonNull(username);
        this.username = requireNonNull(username);
        this.password = requireNonNull(password);
        this.authorities = new ArrayList<>();
        addRoles(roles);
    }

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        return authorities;
    }

    private void addRoles(List<String> roleNames) {
        for (String roleName : roleNames) {
            addRole(roleName);
        }
    }

    public void addRole(String roleName) {
        this.authorities.add(new SimpleGrantedAuthority(roleName));
    }

    public void removeRole(String roleName) {
        Optional<SimpleGrantedAuthority> role = authorities.stream().filter(a -> a.getAuthority().equals(roleName))
                .findFirst();
        if (role.isPresent())
            authorities.remove(role.get());
    }

    public boolean isInAnyRole(List<String> roleNames) {
        return authorities.stream().filter(a -> roleNames.contains(a.getAuthority())).count() > 0;
    }

    public String getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

