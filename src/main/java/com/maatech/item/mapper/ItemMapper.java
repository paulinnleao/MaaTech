package com.maatech.item.mapper;

import com.maatech.item.entity.Item;
import com.maatech.item.entity.ItemRequestDTO;
import com.maatech.item.entity.ItemResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    ItemResponseDTO fromEntityToResponseDTO(Item item);
    ItemRequestDTO fromEntityToRequestDTO(Item item);

    Item fromRequestDtoToEntity(ItemRequestDTO dto);

    Item fromResponseDtoToEntity(ItemResponseDTO dto);
}
