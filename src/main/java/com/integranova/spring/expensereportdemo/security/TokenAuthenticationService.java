package com.integranova.spring.expensereportdemo.security;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableMap;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import com.integranova.spring.expensereportdemo.viewmodel.LoginRequest;

@Service
public class TokenAuthenticationService implements UserAuthenticationService {

    @Autowired
    TokenService tokens;

    @Autowired
    UserCrudService users;

    @Override
    public Optional<String> login(String username, String password) {
        Optional<User> user = users.findByUsername(username);
        if (user.isPresent()) {
            return user.filter(u -> Objects.equals(Utilities.encrypt(password), u.getPassword()))
                    .map(u -> tokens.expiring(ImmutableMap.of("username", username)));
        }
        return Optional.empty();
    }

    @Override
    public Optional<String> login(LoginRequest loginRequest){
    	Optional<User> user = loginRequest.getFacetname() == null || loginRequest.getFacetname().isEmpty()
    						? users.findByUsername(loginRequest.getUsername()) 
    						: users.findByFacetAndUsername(loginRequest.getFacetname(), loginRequest.getUsername());
        if (user.isPresent()) {
            return user.filter(u -> Objects.equals(Utilities.encrypt(loginRequest.getPassword()), u.getPassword()))
                    .map(u -> tokens.expiring(ImmutableMap.of("username", loginRequest.getUsername())));
        }
    	return Optional.empty();
    }

    @Override
    public Optional<User> findByToken(String token) {
        return Optional.of(tokens.verify(token)).map(attributes -> attributes.get("username"))
                .flatMap(users::findByUsername);
    }

    @Override
    public void logout(User user) {
        // No additional logic
    }

}

