package com.maatech.user.rest;

import com.maatech.user.entity.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class UserRestImp implements UserRest{
    @Override
    public ResponseEntity<?> findUserById(UUID idUser) {
        return null;
    }

    @Override
    public List<ResponseEntity<?>> findAllUser() {
        return List.of();
    }

    @Override
    public ResponseEntity<?> createUser(UserDTO user) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateUser(UserDTO user) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteUserById(UUID idUser) {
        return null;
    }
}
