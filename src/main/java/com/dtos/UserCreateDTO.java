package com.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(
        @NotBlank String username,
        @Email String email,
        @NotBlank String password
) {
}
