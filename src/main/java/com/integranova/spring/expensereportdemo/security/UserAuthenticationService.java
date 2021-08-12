package com.integranova.spring.expensereportdemo.security;

import java.util.Optional;

import com.integranova.spring.expensereportdemo.viewmodel.LoginRequest;

public interface UserAuthenticationService {

    Optional<String> login(String username, String password);
    
    Optional<String> login(LoginRequest loginRequest);

    Optional<User> findByToken(String token);

    void logout(User user);
}
