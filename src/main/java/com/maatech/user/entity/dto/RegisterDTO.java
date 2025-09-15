package com.maatech.user.entity.dto;

import com.maatech.user.entity.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RegisterDTO {

    @Schema(description = "Nome completo do usuário", example = "Paulo Henrique", required = true)
    private String name;

    @Schema(description = "E-mail do usuário para login", example = "paulo@email.com", required = true)
    private String email;

    @Schema(description = "Senha do usuário", example = "SenhaForte123!", required = true)
    private String password;

    @Schema(description = "Papel do usuário no sistema (não pode ser alterado no registro)", example = "USER")
    private final UserRole role = UserRole.USER;

    public RegisterDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public RegisterDTO() {
    }
}
