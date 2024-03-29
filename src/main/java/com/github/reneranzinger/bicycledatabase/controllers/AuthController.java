package com.github.reneranzinger.bicycledatabase.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.reneranzinger.bicycledatabase.auth.jwt.JwtUtils;
import com.github.reneranzinger.bicycledatabase.auth.model.UserDetailsImpl;
import com.github.reneranzinger.bicycledatabase.dto.request.LoginRequest;
import com.github.reneranzinger.bicycledatabase.dto.response.JwtResponse;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController
{
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager m_authenticationManager;

    @Autowired
    JwtUtils m_jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateuser(@RequestBody LoginRequest loginRequest)
    {
        logger.info("AuthController::authenticateuser");
        Authentication t_authentication = this.m_authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(t_authentication);
        String jwt = this.m_jwtUtils.generateJwtToken(t_authentication);

        UserDetailsImpl t_userDetails = (UserDetailsImpl) t_authentication.getPrincipal();

        return ResponseEntity
                .ok(new JwtResponse(jwt, t_userDetails.getId(), t_userDetails.getUsername()));
    }

}
