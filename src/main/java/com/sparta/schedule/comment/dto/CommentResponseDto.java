package com.sparta.schedule.comment.dto;

import com.sparta.schedule.comment.entity.CommentEntity;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class CommentResponseDto {

    private final Long id;
    private final String content;
    private final String username;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CommentResponseDto(CommentEntity commentEntity){
        this.id = commentEntity.getId();
        this.username = commentEntity.getUsername();
        this.content  =  commentEntity.getContent();
        this.createdAt = commentEntity.getCreatedAt();
        this.updatedAt = commentEntity.getUpdatedAt();

    }

}
