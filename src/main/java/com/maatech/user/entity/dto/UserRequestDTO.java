package com.maatech.user.entity.dto;

import com.maatech.user.entity.UserRole;
import lombok.Data;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class UserRequestDTO {

    @Schema(description = "ID do usuário (apenas para atualização)", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID idUser;

    @Schema(description = "Nome completo do usuário", example = "Paulo Henrique", required = true)
    private String name;

    @Schema(description = "E-mail do usuário", example = "paulo@email.com", required = true)
    private String email;

    @Schema(description = "Senha do usuário", example = "SenhaForte123!", required = true)
    private String password;

    @Schema(description = "Função ou papel do usuário", example = "ADMIN", required = true)
    private UserRole role;

    public UserRequestDTO() {
    }

    public UserRequestDTO(UUID idUser, String name, String email, String password, UserRole role) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public UserRequestDTO(String name, String email, String password, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}