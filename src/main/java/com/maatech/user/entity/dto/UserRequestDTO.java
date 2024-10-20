package com.maatech.user.entity.dto;

import com.maatech.user.entity.UserRole;
import lombok.Data;

import java.util.UUID;

@Data
public class UserRequestDTO {

    private UUID idUser;
    private String name;
    private String email;
    private String password;
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
