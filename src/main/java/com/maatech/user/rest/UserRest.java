package com.maatech.user.rest;

import com.maatech.user.entity.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface UserRest {

    ResponseEntity<?> findUserById(UUID idUser);
    List<ResponseEntity<?>> findAllUser();
    ResponseEntity<?> createUser(UserDTO user);
    ResponseEntity<?> updateUser(UserDTO user);
    ResponseEntity<?> deleteUserById(UUID idUser);
}
