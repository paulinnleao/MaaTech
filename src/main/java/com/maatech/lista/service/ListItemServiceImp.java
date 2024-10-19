package com.maatech.lista.service;

import com.maatech.exception.ResourceNotFoundException;
import com.maatech.item.entity.Item;
import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import com.maatech.item.mapper.ItemMapper;
import com.maatech.item.service.ItemService;
import com.maatech.lista.entity.ListItem;
import com.maatech.lista.repository.ListItemRepository;
import com.maatech.user.entity.User;
import com.maatech.user.mapper.UserMapper;
import com.maatech.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ListItemServiceImp implements ListItemService {

    @Autowired
    ListItemRepository repository;

    @Autowired
    ItemService itemService;

    @Autowired
    UserService userService;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public ResponseEntity<?> findListByIdUser(UUID idUser) {
        List<ListItem> userItemList = repository.findUserItemList(idUser);

        if(userItemList.isEmpty()){
            throw new ResourceNotFoundException("There isn't list for this UUID: " + idUser);
        }

        return ResponseEntity.ok(userItemList);
    }

    @Override
    public ResponseEntity<List<?>> listAllLitsItems() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    public ListItem addNewItemToList(UUID idUser, ItemRequestDTO itemRequestDTO) {
        if(repository.findById(new ListItem.ListItemId(idUser, itemRequestDTO.getIdItem())).isEmpty()){

            User user = userMapper.fromResponseDtoToEntity(userService.findUserById(idUser));
            ItemResponseDTO itemResponseDTO = itemService.findItemById(itemRequestDTO.getIdItem());

            Item item = new Item();

            if(Objects.nonNull(itemResponseDTO)){

                item = itemMapper.fromResponseDtoToEntity(itemResponseDTO);
                // Verificar se está autenticado na v2
                return repository.save(new ListItem(user, item));
            }else{
                item = itemMapper.fromResponseDtoToEntity(itemService.createItem(itemRequestDTO));
                return repository.save(new ListItem(user, item));
            }
        }
        return null;
    }

    @Override
    public ResponseEntity<?> deleteItemFromUserList(UUID idUser, UUID idItem) {
        return null;
    }
}
