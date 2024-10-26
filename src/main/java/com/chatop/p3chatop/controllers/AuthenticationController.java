package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.LoginUserDTO;
import com.chatop.p3chatop.dto.MeResponseDTO;
import com.chatop.p3chatop.dto.RegisterUserDTO;
import com.chatop.p3chatop.dto.TokenResponseDTO;
import com.chatop.p3chatop.entities.User;
import com.chatop.p3chatop.repositories.UserRepository;
import com.chatop.p3chatop.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentification", description = "Authentification management APIs")
@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    public AuthenticationController(AuthenticationService authenticationService, UserRepository userRepository) {
        this.authenticationService = authenticationService;
        this.userRepository = userRepository;
    }


    @Operation(
            summary = "Authentification d'un utilisateur",
            description = "Authentifie un utilisateur avec les informations fournies."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TokenResponseDTO.class), mediaType = "application/json") }),
    })
    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> register(@RequestBody RegisterUserDTO registerUserDto) {
        TokenResponseDTO registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }


    @Operation(
            summary = "Authentification d'un utilisateur",
            description = "Authentifie un utilisateur avec les informations fournies."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TokenResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", content = { @Content(schema = @Schema()) }),
    })
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        TokenResponseDTO authenticatedUser = authenticationService.authenticate(loginUserDto);

        return ResponseEntity.ok(authenticatedUser);
    }


    @Operation(
            summary = "Informations de l'utilisateur authentifié",
            description = "Récupère les informations de l'utilisateur authentifié.",
            security = { @SecurityRequirement(name = "bearerAuth")}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = MeResponseDTO.class), mediaType = "application/json")}),
    })
    @Parameters({
            @Parameter(
                    name = "Authorization", description = "Bearer Token", required = true
            )
    })
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
