package com.maatech.user.rest;

import com.maatech.user.entity.UserRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserRestImp implements UserRest{
    @Override
    @GetMapping("/{idUser}")
    public ResponseEntity<?> findUserById(@PathVariable(value = "idUser") UUID idUser) {
        return null;
    }

    @Override
    @GetMapping
    public List<ResponseEntity<?>> findAllUser() {
        return List.of();
    }

    @Override
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO user) {
        return null;
    }

    @Override
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserRequestDTO user) {
        return null;
    }

    @Override
    @DeleteMapping("/{idUser}")
    public ResponseEntity<?> deleteUserById(@PathVariable(value = "idUser") UUID idUser) {
        return null;
    }
}
