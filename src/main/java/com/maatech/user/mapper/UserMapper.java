package com.maatech.user.mapper;

import com.maatech.user.entity.User;
import com.maatech.user.entity.UserRequestDTO;
import com.maatech.user.entity.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromRequestDtoToEntity(UserRequestDTO dto);
    User fromResponseDtoToEntity(UserResponseDTO dto);

    UserRequestDTO fromEntityToRequestDTO(User user);
    UserResponseDTO fromEntityToResponseDTO(User user);
}
