package com.codecat.TidyUp.dto;

import com.codecat.TidyUp.model.Role;

public record AuthUserResponse(Long id, String username, Role role) {
}

