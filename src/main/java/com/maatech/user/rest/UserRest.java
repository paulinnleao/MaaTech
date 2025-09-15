package com.maatech.user.rest;

import com.maatech.user.entity.dto.UserRequestDTO;
import com.maatech.user.entity.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserRest {

    ResponseEntity<?> findUserById(UUID idUser);
    ResponseEntity<List<UserResponseDTO>> findAllUser();
    ResponseEntity<?> createUser(UserRequestDTO user);
    ResponseEntity<?> updateUser(UserRequestDTO user);
    ResponseEntity<?> deleteUserById(UUID idUser);

    ResponseEntity<?> findUserByMail(String email);
}
