package com.sparta.schedule.user.dto;

import com.sparta.schedule.user.entity.UserEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {

    private final Long id;
    private final String username;
    private final String email;

    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public UserResponseDto(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();
        this.createdAt = userEntity.getCreatedAt();
        this.updatedAt = userEntity.getUpdatedAt();
    }
}
