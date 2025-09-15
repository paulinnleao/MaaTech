package com.maatech.item.rest;

import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import com.maatech.item.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemRestImp implements ItemRest {

    @Autowired
    private ItemService service;

    @Override
    @Operation(summary = "Busca um item pelo ID", description = "Retorna um item específico a partir do UUID fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado")
    })
    @GetMapping("{idItem}")
    public ResponseEntity<ItemResponseDTO> findItemById(
            @Parameter(description = "UUID do item", required = true) @PathVariable UUID idItem) {
        ItemResponseDTO item = service.findItemById(idItem);
        return ResponseEntity.ok(item);
    }

    @Override
    @Operation(summary = "Lista todos os itens", description = "Retorna uma lista de todos os itens cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de itens retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<ItemResponseDTO>> findAllItems() {
        return ResponseEntity.ok(service.findAllItems());
    }

    @Override
    @Operation(summary = "Cria um novo item", description = "Cria um item com base no DTO fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<ItemResponseDTO> createItem(@RequestBody ItemRequestDTO item) {
        ItemResponseDTO createdItem = service.createItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @Override
    @Operation(summary = "Atualiza um item existente", description = "Atualiza um item com base no DTO fornecido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado")
    })
    @PutMapping
    public ResponseEntity<ItemResponseDTO> updateItem(@RequestBody ItemRequestDTO item) {
        ItemResponseDTO updatedItem = service.updateItem(item);
        return ResponseEntity.ok(updatedItem);
    }

    @Override
    @Operation(summary = "Deleta um item pelo ID", description = "Remove o item específico do banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Item não encontrado")
    })
    @DeleteMapping("{idItem}")
    public ResponseEntity<Void> deleteItemById(@PathVariable UUID idItem) {
        service.deleteItemById(idItem);
        return ResponseEntity.noContent().build();
    }
}
