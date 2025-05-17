package de.ait.userApi.service;

import de.ait.userApi.dto.UserRequestDto;
import de.ait.userApi.dto.UserResponseDto;

import java.util.List;


public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto getUserById(Long id);

    UserResponseDto addUser(UserRequestDto dto);

}
