package com.sparta.schedule.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScheduleRequestDto {

   private String username;
   private String title;
   private  String content;

}
