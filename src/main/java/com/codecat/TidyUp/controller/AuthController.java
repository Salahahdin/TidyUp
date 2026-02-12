package com.codecat.TidyUp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // Dopasuj origin do swojego frontendu
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Logika uwierzytelniania (np. Spring Security AuthenticationManager)
        return ResponseEntity.ok("Zalogowano pomyślnie");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        // Logika rejestracji użytkownika
        return ResponseEntity.ok("Zarejestrowano pomyślnie");
    }

    @PostMapping("/logout")
