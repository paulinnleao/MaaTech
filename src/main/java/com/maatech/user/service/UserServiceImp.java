package com.maatech.user.service;

import com.maatech.user.entity.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{
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
