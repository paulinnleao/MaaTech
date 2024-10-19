package com.maatech.user.service;

import com.maatech.exception.ResourceNotFoundException;
import com.maatech.user.entity.UserRequestDTO;
import com.maatech.user.entity.UserResponseDTO;
import com.maatech.user.mapper.UserMapper;
import com.maatech.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    @Override
    public UserResponseDTO findUserById(UUID idUser) {
        return
                mapper.fromEntityToResponseDTO(
                        repository.findById(idUser)
                                .orElseThrow(()-> new ResourceNotFoundException("There isn't user with this UUID: " + idUser)));
    }

    @Override
    public List<ResponseEntity<?>> findAllUser() {
        return List.of();
    }

    @Override
    public ResponseEntity<?> createUser(UserRequestDTO user) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateUser(UserRequestDTO user) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteUserById(UUID idUser) {
        return null;
    }
}
