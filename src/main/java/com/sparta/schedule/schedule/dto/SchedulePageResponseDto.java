package com.sparta.schedule.schedule.dto;

import com.sparta.schedule.schedule.entity.ScheduleEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePageResponseDto {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
    private final int commentCount;


    public SchedulePageResponseDto(ScheduleEntity scheduleEntity){
        this.id = scheduleEntity.getId();
        this.title = scheduleEntity.getTitle();
        this.content = scheduleEntity.getContent();
        this.createdAt = scheduleEntity.getCreatedAt();
        this.updatedAt = scheduleEntity.getUpdatedAt();
        this.commentCount = scheduleEntity.getComments().size();



    }

}
