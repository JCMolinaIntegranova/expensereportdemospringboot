package com.integranova.spring.expensereportdemo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.google.common.collect.ImmutableMap;
import com.integranova.spring.expensereportdemo.utils.Agent;

@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final String AUTHORIZATION = "Authorization";
    private static final String USERNAME = "username";
	
    @Autowired
    Agent agentSrv;

    @Autowired
    TokenService tokens;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
    	String username = authentication.getName();
        agentSrv.setAgentName(username);
    	String token = tokens.expiring(ImmutableMap.of(USERNAME, username));
    	response.addHeader(AUTHORIZATION, token);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
