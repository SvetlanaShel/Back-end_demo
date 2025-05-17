package de.ait.userApi.service;

import de.ait.userApi.dto.UserRequestDto;
import de.ait.userApi.dto.UserResponseDto;
import de.ait.userApi.mapper.UserMapper;
import de.ait.userApi.model.User;
import de.ait.userApi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper maper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return maper.toDtoList(repository.findAll());
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        User user = repository.findById(id).get();
        if(user!=null){
            return maper.toDto(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public UserResponseDto addUser(UserRequestDto dto) {
        User user = maper.fromDto(dto);
        User savedUser = repository.save(user);
        if(savedUser!=null){
            return maper.toDto(savedUser);
        } else {
            throw  new RuntimeException("Error create new user");
        }

    }

}
