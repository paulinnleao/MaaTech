package com.maatech.user.entity;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResponseDTO {

    private UUID idUser;
    private String name;
    private String email;

    public UserResponseDTO(UUID idUser, String name, String email) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
    }

    public UserResponseDTO() {
    }
}