package com.sparta.schedule.dto;


import com.sparta.schedule.entity.ScheduleEntity;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String username;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ScheduleResponseDto(ScheduleEntity scheduleEntity){
        this.id = scheduleEntity.getId();
        this.username = scheduleEntity.getUsername();
        this.title = scheduleEntity.getTitle();
        this.content = scheduleEntity.getContent();
        this.createdAt = scheduleEntity.getCreatedAt();
        this.updatedAt = scheduleEntity.getUpdatedAt();
    }
}
