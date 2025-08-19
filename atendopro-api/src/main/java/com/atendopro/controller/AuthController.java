package com.atendopro.controller;

import com.atendopro.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String senha) {
        return authService.login(email, senha);
    }
}
