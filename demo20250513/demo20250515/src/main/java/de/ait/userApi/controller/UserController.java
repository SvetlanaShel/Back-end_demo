package de.ait.userApi.controller;

import de.ait.userApi.dto.UserRequestDto;
import de.ait.userApi.dto.UserResponseDto;
import de.ait.userApi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/users")
    public List<UserResponseDto> getUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public UserResponseDto getById(@PathVariable(name = "id") Long userId){
        return service.getUserById(userId);
    }

    @PostMapping("/users")
    public UserResponseDto addUser(@RequestBody UserRequestDto dto){
        return service.addUser(dto);
    }
}
