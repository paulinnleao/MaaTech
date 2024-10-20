package com.maatech.user.entity;

import lombok.Data;

@Data
public class RegisterDTO {


    private String name;
    private String email;
    private String password;
    private final UserRole role = UserRole.USER;

    public RegisterDTO(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public RegisterDTO() {
    }
}
