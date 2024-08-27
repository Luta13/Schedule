package com.sparta.schedule.schedule.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateRequestDto {
    private String username;
    private String title;
    private String content;
}
