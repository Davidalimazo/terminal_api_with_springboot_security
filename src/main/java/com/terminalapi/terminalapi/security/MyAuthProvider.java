package com.terminalapi.terminalapi.security;

import com.terminalapi.terminalapi.repository.TerminalRepository;
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
    PasswordEncoder passwordEncoder;
    @Autowired
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    TerminalRepository terminalRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        if ("user".equals(userName) && encoder.matches(password, passwordEncoder.encode("pass"))) {
            return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
        } else
            throw new BadCredentialsException("Invalid Credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

