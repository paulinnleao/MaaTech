package com.maatech.user.service;

import com.maatech.exception.ResourceNotFoundException;
import com.maatech.user.entity.User;
import com.maatech.user.entity.dto.UserRequestDTO;
import com.maatech.user.entity.dto.UserResponseDTO;
import com.maatech.user.mapper.UserMapper;
import com.maatech.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository repository;

    @Autowired
    UserMapper mapper;

    @Override
    public UserResponseDTO findUserById(UUID idUser) {
        return repository.findById(idUser)
                .map(mapper::fromEntityToResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "There isn't user with this UUID: " + idUser
                ));
    }

    @Override
    public List<UserResponseDTO> findAllUser() {
        List<User> users = repository.findAll();

        List<UserResponseDTO> response = users.stream()
                .map(u -> new UserResponseDTO(u.getIdUser(), u.getName(), u.getEmail()))
                .toList();

        return response;
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
    public Optional<UserResponseDTO> updateUser(UserRequestDTO userDto) {
        return repository.findById(userDto.getIdUser())
                .map(existingUser -> {
                    existingUser.setName(userDto.getName());
                    existingUser.setEmail(userDto.getEmail());
                    existingUser.setPassword(userDto.getPassword());
                    User updated = repository.save(existingUser);
                    return new UserResponseDTO(updated.getIdUser(), updated.getName(), updated.getEmail());
                });
    }

    @Override
    public boolean deleteUserById(UUID idUser) {
        return repository.findById(idUser)
                .map(user -> {
                    repository.delete(user);
                    return true;
                })
                .orElse(false);
    }

}
