package com.maatech.user.service;

import com.maatech.user.entity.dto.UserRequestDTO;
import com.maatech.user.entity.dto.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserResponseDTO findUserById(UUID idUser);
    List<UserResponseDTO> findAllUser();
    ResponseEntity<?> createUser(UserRequestDTO user);
    Optional<UserResponseDTO> updateUser(UserRequestDTO user);
    boolean deleteUserById(UUID idUser);

    UserResponseDTO findUserByMail(String email);
}
