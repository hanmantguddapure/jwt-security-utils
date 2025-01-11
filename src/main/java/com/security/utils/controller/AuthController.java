package com.security.utils.controller;

import com.security.utils.dto.request.AuthDetails;
import com.security.utils.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthDetails authRequest) {
        return jwtService.generateToken(authRequest.getUsername());
    }
}