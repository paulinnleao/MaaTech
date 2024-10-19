package com.maatech.item.rest;

import com.maatech.item.entity.ItemRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemRestImp implements ItemRest{
    @Override
    @GetMapping("{idItem}")
    public ResponseEntity<?> findItemById(@PathVariable(value = "idItem") UUID idItem) {
        return null;
    }

    @Override
    @GetMapping
    public List<ResponseEntity<?>> findAllItems() {
        return List.of();
    }

    @Override
    @PostMapping("/{idItem}")
    public ResponseEntity<?> createItem(@PathVariable("idItem") ItemRequestDTO item) {
        return null;
    }

    @Override
    @PutMapping("/{idItem}")
    public ResponseEntity<?> updateItem(@PathVariable("idItem") ItemRequestDTO item) {
        return null;
    }

    @Override
    @DeleteMapping("/{idItem}")
    public ResponseEntity<?> deleteItemById(@PathVariable("idItem") UUID idItem) {
        return null;
    }
}
