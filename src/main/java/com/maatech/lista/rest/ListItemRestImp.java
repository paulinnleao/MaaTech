package com.maatech.lista.rest;

import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.lista.entity.ListItem;
import com.maatech.lista.entity.ListItemResponseDTO;
import com.maatech.lista.service.ListItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/list-of-items")
public class ListItemRestImp implements ListItemRest{

    @Autowired
    ListItemService service;

    @Override
    @GetMapping("/{idUser}")
    public ResponseEntity<List<ListItemResponseDTO>> findUserItemList(@PathVariable("idUser") UUID idUser) {
        return ResponseEntity.ok(service.findUserItemList(idUser));
    }

    @Override
    @GetMapping
    public List<ResponseEntity<?>> listAllLitsItems() {
        return List.of();
    }

    @Override
    @PostMapping("/{idUser}")
    public ResponseEntity<ListItemResponseDTO> addNewItemToList(@PathVariable("idUser") UUID idUser, @RequestBody ItemRequestDTO itemRequestDTO) {
        return ResponseEntity.ok(service.addNewItemToList(idUser, itemRequestDTO));
    }

    @Override
    @DeleteMapping("/{idUser}/{idItem}")
    public ResponseEntity<?> deleteItemFromUserList(@PathVariable("idUser") UUID idUser, @PathVariable("idItem") UUID idItem) {
        return service.deleteItemFromUserList(idUser, idItem);
    }
}
