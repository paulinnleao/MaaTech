package com.maatech.user.service;

import com.maatech.user.entity.dto.UserRequestDTO;
import com.maatech.user.entity.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponseDTO findUserById(UUID idUser);
    List<ResponseEntity<?>> findAllUser();
    ResponseEntity<?> createUser(UserRequestDTO user);
    ResponseEntity<?> updateUser(UserRequestDTO user);
    ResponseEntity<?> deleteUserById(UUID idUser);

    UserResponseDTO findUserByMail(String email);
}
