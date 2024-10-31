package com.chatop.p3chatop.controllers;

import com.chatop.p3chatop.dto.MeResponseDTO;
import com.chatop.p3chatop.services.UserInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MeResponseDTO> getUser(@PathVariable Integer id) {

        MeResponseDTO meResponseDTO = userInfoService.getUserById(id);

        return ResponseEntity.ok(meResponseDTO);
    }
}
