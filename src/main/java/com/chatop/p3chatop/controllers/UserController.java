package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.MeResponseDTO;
import com.chatop.p3chatop.services.UserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "User", description = "User management APIs")
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @Operation(
            summary = "Récupérer un utilisateur par ID",
            description = "Récupère les informations d'un utilisateur en fonction de son ID."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    content = { @Content(schema = @Schema(implementation = MeResponseDTO.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "401",
                    content = { @Content(schema = @Schema()) })
    })
    @GetMapping("/{id}")
    public ResponseEntity<MeResponseDTO> getUser(@PathVariable Integer id) {

        MeResponseDTO meResponseDTO = userInfoService.getUserById(id);

        return ResponseEntity.ok(meResponseDTO);
    }
}
