package com.sparta.schedule.schedule.dto;


import com.sparta.schedule.comment.dto.CommentResponseDto;
import com.sparta.schedule.schedule.entity.ScheduleEntity;
import com.sparta.schedule.scheduleuser.dto.ScheduleUserResponseDto;
import com.sparta.schedule.scheduleuser.entity.ScheduleUserEntity;
import com.sparta.schedule.user.dto.UserResponseDto;
import com.sparta.schedule.user.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int commentCount;
    private List<ScheduleUserResponseDto> scheduleUsers;

    public ScheduleResponseDto(ScheduleEntity scheduleEntity) {
        this.id = scheduleEntity.getId();
        this.title = scheduleEntity.getTitle();
        this.content = scheduleEntity.getContent();
        this.createdAt = scheduleEntity.getCreatedAt();
        this.updatedAt = scheduleEntity.getUpdatedAt();
        this.commentCount = scheduleEntity.getComments().size();

    }


}
