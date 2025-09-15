package com.maatech.user.rest;

import com.maatech.user.entity.dto.UserRequestDTO;
import com.maatech.user.entity.dto.UserResponseDTO;
import com.maatech.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserRestImp implements UserRest {

    @Autowired
    UserService service;

    @Override
    @Operation(summary = "Busca usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/{idUser}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable(value = "idUser") UUID idUser) {
        UserResponseDTO user = service.findUserById(idUser);
        return ResponseEntity.ok(user);
    }

    @Override
    @Operation(summary = "Busca usuário pelo e-mail")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário encontrado"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @GetMapping("/email/{email}")
    public ResponseEntity<?> findUserByMail(@PathVariable(value = "email") String email) {
        return ResponseEntity.ok(service.findUserByMail(email));
    }
    @Override
    @Operation(summary = "Lista todos os usuários")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUser() {
        return ResponseEntity.ok(service.findAllUser());
    }


    @Override
    @Operation(summary = "Cria um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO user) {
        return null;
    }

    @Override
    @Operation(summary = "Atualiza um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Usuário não encontrado")
    })
    @PutMapping
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserRequestDTO userDto) {
        return service.updateUser(userDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @Override
    @Operation(summary = "Deleta um usuário pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Usuário não encontrado")
    })
    @DeleteMapping("/{idUser}")
    public ResponseEntity<?> deleteUserById(@PathVariable UUID idUser) {
        return service.deleteUserById(idUser)
                ? ResponseEntity.ok("Usuário deletado com sucesso")
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
    }
}