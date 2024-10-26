package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.LoginResponseDTO;
import com.chatop.p3chatop.dto.LoginUserDTO;
import com.chatop.p3chatop.dto.RegisterUserDTO;
import com.chatop.p3chatop.dto.TokenResponseDTO;
import com.chatop.p3chatop.entities.User;
import com.chatop.p3chatop.services.AuthenticationService;
import com.chatop.p3chatop.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> register(@RequestBody RegisterUserDTO registerUserDto) {
        TokenResponseDTO registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        TokenResponseDTO authenticatedUser = authenticationService.authenticate(loginUserDto);

        return ResponseEntity.ok(authenticatedUser);
    }

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }
}
