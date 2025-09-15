package com.maatech.user.entity.dto;

import com.maatech.user.entity.UserRole;
import lombok.Data;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.UUID;

@Data
public class UserResponseDTO {

    @Schema(description = "ID do usuário", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID idUser;

    @Schema(description = "Nome completo do usuário", example = "Paulo Henrique")
    private String name;

    @Schema(description = "E-mail do usuário", example = "paulo@email.com")
    private String email;

    @Schema(description = "Função ou papel do usuário", example = "ADMIN")
    private UserRole role;

    public UserResponseDTO(UUID idUser, String name, String email, UserRole role) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public UserResponseDTO() {
    }
}
