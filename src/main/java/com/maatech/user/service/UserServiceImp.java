package com.maatech.user.service;

import com.maatech.exception.ResourceNotFoundException;
import com.maatech.user.entity.User;
import com.maatech.user.entity.dto.UserRequestDTO;
import com.maatech.user.entity.dto.UserResponseDTO;
import com.maatech.user.mapper.UserMapper;
import com.maatech.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
    public ResponseEntity<?> createUser(UserRequestDTO userRequestDTO) {
        try{
            User user = mapper.fromRequestDtoToEntity(userRequestDTO);
            User savedUser = repository.save(user);
            System.out.println("Saved user: " + savedUser);
            return ResponseEntity.ok(mapper.fromEntityToResponseDTO(savedUser));
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public UserResponseDTO findUserByMail(String email){
        User user = repository.findUser(email);
        if(Objects.isNull(user)){
            throw new ResourceNotFoundException("There isn't user with this Email: " + email);
        }
        return mapper.fromEntityToResponseDTO(user);
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
