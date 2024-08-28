package com.sparta.schedule.user.service;



import com.sparta.schedule.user.dto.UserRequestDto;
import com.sparta.schedule.user.dto.UserResponseDto;
import com.sparta.schedule.user.entity.UserEntity;
import com.sparta.schedule.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = new UserEntity(userRequestDto);
        UserEntity saveUser = userRepository.save(userEntity);

        UserResponseDto userResponseDto = new UserResponseDto(saveUser);
        return userResponseDto;
    }

    public UserResponseDto getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        UserResponseDto userResponseDto = new UserResponseDto(userEntity);
        return userResponseDto;
    }

    public List<UserResponseDto> getUsers() {
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
    }

    @Transactional
    public void updateUser(Long id, UserRequestDto userRequestDto) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        userEntity.update(userEntity);
    }

    public void deleteUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        userRepository.delete(userEntity);
    }


}
