package com.chatop.p3chatop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RessourceController {

    @GetMapping("/")
    public String getRessource() {
        return "a value...";
    }
}
