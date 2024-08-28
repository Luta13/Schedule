package com.sparta.schedule.schedule.dto;


import com.sparta.schedule.user.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequestDto {
    private UserEntity user;
    private String title;
    private String content;
}
