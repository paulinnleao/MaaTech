package com.maatech.user.service;

import com.maatech.user.entity.UserRequestDTO;
import com.maatech.user.entity.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponseDTO findUserById(UUID idUser);
    List<ResponseEntity<?>> findAllUser();
    ResponseEntity<?> createUser(UserRequestDTO user);
    ResponseEntity<?> updateUser(UserRequestDTO user);
    ResponseEntity<?> deleteUserById(UUID idUser);
}
