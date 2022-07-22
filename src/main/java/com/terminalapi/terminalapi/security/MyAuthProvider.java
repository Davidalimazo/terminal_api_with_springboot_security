package com.terminalapi.terminalapi.security;

import com.terminalapi.terminalapi.entity.Agent;
import com.terminalapi.terminalapi.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MyAuthProvider implements AuthenticationProvider {
    @Autowired
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    AgentRepository agentRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        Agent agent = agentRepository.findByTerminalId(userName);
        if (agent.getTerminalId().equals(userName) && encoder.matches(password, agent.getPassword())) {
            return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
        } else
            throw new BadCredentialsException("Invalid Credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

