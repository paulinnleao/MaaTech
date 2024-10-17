package com.maatech.lista.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/list-of-items")
public class ListItemRestImp implements ListItemRest{
    @Override
    @GetMapping("/{idUser}")
    public List<ResponseEntity<?>> findListByIdUser(@PathVariable("idUser") UUID idUser) {
        return List.of();
    }

    @Override
    @GetMapping
    public List<ResponseEntity<?>> listAllLitsItems() {
        return List.of();
    }

    @Override
    @PostMapping("/{idUser}/{idItem}")
    public ResponseEntity<?> addNewItemToList(@PathVariable("idUser") UUID idUser, @PathVariable("idItem") UUID idItem) {
        return null;
    }

    @Override
    @DeleteMapping("/{idUser}/{idItem}")
    public ResponseEntity<?> deleteItemFromUserList(@PathVariable("idUser") UUID idUser, @PathVariable("idItem") UUID idItem) {
        return null;
    }
}
