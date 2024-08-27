package com.sparta.schedule.schedule.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ScheduleRequestDto {

   private String username;
   private String title;
   private  String content;

}
