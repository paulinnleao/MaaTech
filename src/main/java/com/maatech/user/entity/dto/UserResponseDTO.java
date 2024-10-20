package com.maatech.user.entity.dto;

import com.maatech.user.entity.UserRole;
import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDTO {

    private UUID idUser;
    private String name;
    private String email;
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