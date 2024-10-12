package com.maatech.user.service;

import com.maatech.user.entity.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    ResponseEntity<?> findUserById(UUID idUser);
    List<ResponseEntity<?>> findAllUser();
    ResponseEntity<?> createUser(UserDTO user);
    ResponseEntity<?> updateUser(UserDTO user);
    ResponseEntity<?> deleteUserById(UUID idUser);
}
