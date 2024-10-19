package com.maatech.user.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class UserRequestDTO {

    private UUID idUser;
    private String name;
    private String email;
    private String password;

    public UserRequestDTO() {
    }

    public UserRequestDTO(UUID idUser, String name, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRequestDTO userRequestDTO = (UserRequestDTO) o;
        return Objects.equals(idUser, userRequestDTO.idUser) && Objects.equals(name, userRequestDTO.name) && Objects.equals(email, userRequestDTO.email) && Objects.equals(password, userRequestDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, email, password);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
