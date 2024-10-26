package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.LoginUserDTO;
import com.chatop.p3chatop.dto.MeResponseDTO;
import com.chatop.p3chatop.dto.RegisterUserDTO;
import com.chatop.p3chatop.dto.TokenResponseDTO;
import com.chatop.p3chatop.entities.User;
import com.chatop.p3chatop.repositories.UserRepository;
import com.chatop.p3chatop.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationService authenticationService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
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
    public ResponseEntity<MeResponseDTO> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow();

        MeResponseDTO meResponseDTO = new MeResponseDTO();
        meResponseDTO.setId(user.getId());
        meResponseDTO.setName(user.getName());
        meResponseDTO.setEmail(email);
        meResponseDTO.setCreated_at(user.getCreatedAt());
        meResponseDTO.setUpdated_at(user.getUpdatedAt());

        return ResponseEntity.ok(meResponseDTO);
    }
}
