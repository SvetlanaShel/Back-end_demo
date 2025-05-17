package de.ait.userApi.mapper;

import de.ait.userApi.dto.ProductRequestDto;
import de.ait.userApi.dto.ProductResponseDto;
import de.ait.userApi.dto.UserRequestDto;
import de.ait.userApi.dto.UserResponseDto;
import de.ait.userApi.model.Product;
import de.ait.userApi.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromDto(UserRequestDto dto);
    UserResponseDto toDto (User user);
    List<UserResponseDto> toDtoList (List<User> user);
}
