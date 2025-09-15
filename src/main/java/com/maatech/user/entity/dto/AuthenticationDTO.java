package com.maatech.user.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AuthenticationDTO {

    @Schema(description = "E-mail do usuário para login", example = "paulo@email.com", required = true)
    private String email;

    @Schema(description = "Senha do usuário", example = "SenhaForte123!", required = true)
    private String password;

    public AuthenticationDTO() {
    }

    public AuthenticationDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
