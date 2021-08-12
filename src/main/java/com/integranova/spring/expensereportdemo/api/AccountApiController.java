package com.integranova.spring.expensereportdemo.api;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integranova.spring.expensereportdemo.security.User;
import com.integranova.spring.expensereportdemo.security.UserAuthenticationService;
import com.integranova.spring.expensereportdemo.viewmodel.LoginRequest;
import com.integranova.spring.expensereportdemo.viewmodel.UserInfoViewModel;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/")
@Api(value="Account")
public class AccountApiController {

    @Autowired
    UserAuthenticationService authenticationService;

    @PostMapping("/Token")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        Optional<String> token = authenticationService.login(loginRequest);
        if (token.isPresent()) {
        	return new ResponseEntity<>("\"" + token.get() + "\"", HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/api/Account/Logout")
    public boolean logout(@AuthenticationPrincipal User user) {
        authenticationService.logout(user);
        return true;
    }

    @PostMapping("/api/Account/UserInfo")
    public UserInfoViewModel getUserInfo(Authentication authentication) {
        UserInfoViewModel userInfo = new UserInfoViewModel();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            String userRoles = user.getAuthorities().stream().map(x -> mapAuthority(x.getAuthority()))
                    .collect(Collectors.joining(","));
            userInfo = new UserInfoViewModel(user.getUsername(), userRoles);
            userInfo.setGridPreferences(new ArrayList<>());
        }
        return userInfo;
    }
    
    private String mapAuthority(String authority) {
    	String mappedAuthority;
    	switch(authority) {
            case "AppUser":
                mappedAuthority = "AppUser";
                break;
            case "AdminUser":
                mappedAuthority = "AdminUser";
                break;
            case "OperatorUser":
                mappedAuthority = "OperatorUser";
                break;
            default:
                mappedAuthority = authority;
        }
        return mappedAuthority;
    }
    @PostMapping("/api/Account/AnonymousUserInfo")
    public UserInfoViewModel getAnonymousUserInfo() {
        return new UserInfoViewModel("", "");
    }
}
