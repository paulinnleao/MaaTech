package com.maatech.item.service;

import com.maatech.exception.ResourceAlreadyExistsException;
import com.maatech.exception.ResourceNotFoundException;
import com.maatech.item.entity.Item;
import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import com.maatech.item.mapper.ItemMapper;
import com.maatech.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ItemServiceImp implements ItemService{

    @Autowired
    ItemRepository repository;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public ItemResponseDTO findItemById(UUID idItem) {
        Item item = repository.findById(idItem)
                .orElseThrow(
                        () -> new ResourceNotFoundException("There isn't item with this UUID: " + idItem));

        return  itemMapper.fromEntityToResponseDTO(item);
    }
    @Override
    public List<ItemResponseDTO> findAllItems() {
        return repository.findAll()
                .stream()
                .map(itemMapper::fromEntityToResponseDTO)
                .toList();
    }

    @Override
    public ItemResponseDTO createItem(ItemRequestDTO itemRequestDTO) {
        if (findItemById(itemRequestDTO.getIdItem()) == null) {
            Item newItem = itemMapper.fromRequestDtoToEntity(itemRequestDTO);
            return itemMapper.fromEntityToResponseDTO(repository.save(newItem));
        }
        throw new ResourceAlreadyExistsException("Item with this UUID already exists: " + itemRequestDTO.getIdItem());
    }

    @Override
    public ItemResponseDTO updateItem(ItemRequestDTO itemRequestDTO) {
        Item existingItem = repository.findById(itemRequestDTO.getIdItem())
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with UUID: " + itemRequestDTO.getIdItem()));
        existingItem.setName(itemRequestDTO.getName());
        existingItem.setDescription(itemRequestDTO.getDescription());
        existingItem.setBrand(itemRequestDTO.getBrand());
        existingItem.setModel(itemRequestDTO.getModel());
        existingItem.setAveragePrice(itemRequestDTO.getAveragePrice());
        existingItem.setCategory(itemRequestDTO.getCategory());
        existingItem.setRating(itemRequestDTO.getRating());
        existingItem.setReviewCount(itemRequestDTO.getReviewCount());
        existingItem.setWeight(itemRequestDTO.getWeight());

        return itemMapper.fromEntityToResponseDTO(repository.save(existingItem));
    }

    @Override
    public void deleteItemById(UUID idItem) {
        Item item = repository.findById(idItem)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with UUID: " + idItem));
        repository.delete(item);
    }
}
