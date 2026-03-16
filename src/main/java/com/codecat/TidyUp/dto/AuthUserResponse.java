package com.codecat.TidyUp.dto;

import com.codecat.TidyUp.model.Role;

import java.util.Date;

public record AuthUserResponse(Long id, String username, Role role, String email, Boolean active, Date createdAt) {
}

