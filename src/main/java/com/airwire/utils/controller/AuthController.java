package com.airwire.utils.controller;

import com.airwire.utils.dto.request.AuthDetails;
import com.airwire.utils.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthDetails authRequest) {
        userDetailsService.loadUserByUsername(authRequest.getUsername());
        return jwtService.generateToken(authRequest.getUsername());
    }
}