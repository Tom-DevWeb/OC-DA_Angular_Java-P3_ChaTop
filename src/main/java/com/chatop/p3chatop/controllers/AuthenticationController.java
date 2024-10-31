package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.LoginUserDTO;
import com.chatop.p3chatop.dto.MeResponseDTO;
import com.chatop.p3chatop.dto.RegisterUserDTO;
import com.chatop.p3chatop.dto.TokenResponseDTO;
import com.chatop.p3chatop.services.AuthenticationService;
import com.chatop.p3chatop.services.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentification", description = "Authentification management APIs")
@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserInfoService userInfoService;

    public AuthenticationController(AuthenticationService authenticationService, UserInfoService userInfoService) {
        this.authenticationService = authenticationService;
        this.userInfoService = userInfoService;
    }


    @Operation(
            summary = "Authentification d'un utilisateur",
            description = "Authentifie un utilisateur avec les informations fournies."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TokenResponseDTO.class), mediaType = "application/json") }),
    })
    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> register(@Valid @RequestBody RegisterUserDTO registerUserDto) {
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
    public ResponseEntity<TokenResponseDTO> authenticate(@Valid @RequestBody LoginUserDTO loginUserDto) {
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

        MeResponseDTO meResponseDTO = userInfoService.getUser(email);

        return ResponseEntity.ok(meResponseDTO);
    }
}
