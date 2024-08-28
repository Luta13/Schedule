package com.sparta.schedule.user.controller;


import com.sparta.schedule.schedule.repository.ScheduleRepository;
import com.sparta.schedule.scheduleuser.repository.ScheduleUserRepository;
import com.sparta.schedule.user.dto.UserRequestDto;
import com.sparta.schedule.user.dto.UserResponseDto;
import com.sparta.schedule.user.repository.UserRepository;
import com.sparta.schedule.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final UserService userService;




    public UserController(UserService userService){
        this.userService = userService;
    }
    //유저를 저장, 단건 조회, 전체 조회, 수정, 삭제할 수 있습니다.
    @PostMapping("/user")
    public UserResponseDto addUser(@RequestBody UserRequestDto userRequestDto)
    {
        return userService.addUser(userRequestDto);
    }
    @GetMapping("/user/{id}")
    public UserResponseDto getUser(@PathVariable Long id)
    {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<UserResponseDto> getUsers()
    {
        return userService.getUsers();
    }

    @PatchMapping("/user/{id}")
    public void updateUser(@PathVariable Long id,@RequestBody UserRequestDto userRequestDto)
    {
         userService.updateUser(id,userRequestDto);
    }

    @DeleteMapping("/user/{id}")
    public void deleteSchedule(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }






}
