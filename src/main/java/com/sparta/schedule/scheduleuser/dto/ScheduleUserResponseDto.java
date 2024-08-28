package com.sparta.schedule.scheduleuser.dto;

import com.sparta.schedule.schedule.entity.ScheduleEntity;
import com.sparta.schedule.scheduleuser.entity.ScheduleUserEntity;
import com.sparta.schedule.user.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleUserResponseDto {
    private Long id;
    private String username;
    private String email;

    public ScheduleUserResponseDto(UserEntity user)
    {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();

    }
}
