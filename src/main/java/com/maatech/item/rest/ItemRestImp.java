package com.maatech.item.rest;

import com.maatech.item.entity.ItemRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemRestImp implements ItemRest {

    @Override
    @Operation(summary = "Busca um item pelo ID", description = "Retorna um item específico a partir do UUID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado")
    })
    @GetMapping("{idItem}")
    public ResponseEntity<?> findItemById(
            @Parameter(description = "UUID do item", required = true) @PathVariable UUID idItem) {
        return null;
    }

    @Override
    @Operation(summary = "Lista todos os itens", description = "Retorna uma lista de todos os itens cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de itens retornada com sucesso")
    })
    @GetMapping
    public List<ResponseEntity<?>> findAllItems() {
        return List.of();
    }

    @Override
    @Operation(summary = "Cria um novo item", description = "Cria um item com base no DTO fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<?> createItem(@RequestBody ItemRequestDTO item) {
        return null;
    }

    @Override
    @Operation(summary = "Atualiza um item existente", description = "Atualiza um item com base no DTO fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado")
    })
    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody ItemRequestDTO item) {
        return null;
    }

    @Override
    @Operation(summary = "Deleta um item pelo ID", description = "Remove o item específico do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado")
    })
    @DeleteMapping("{idItem}")
    public ResponseEntity<?> deleteItemById(
            @Parameter(description = "UUID do item", required = true) @PathVariable UUID idItem) {
        return null;
    }
}
