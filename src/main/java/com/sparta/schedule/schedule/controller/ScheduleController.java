package com.sparta.schedule.schedule.controller;


import com.sparta.schedule.schedule.dto.SchedulePageResponseDto;
import com.sparta.schedule.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.schedule.dto.UpdateRequestDto;
import com.sparta.schedule.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedule")
    public void addSchedule(@RequestBody ScheduleRequestDto requestDto)
    {
         scheduleService.addSchedule(requestDto);
    }

    @GetMapping("/schedules")
    public List<SchedulePageResponseDto> getSchedules(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize)
    {
        return scheduleService.getSchedules(pageNo, pageSize);
    }

    @GetMapping("/schedule/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id)
    {
        return scheduleService.getSchedule(id);
    }

    @PatchMapping("/schedule/{id}") // 전체수정 put, 단건수정 patch
    public void updateSchedule(@PathVariable Long id, @RequestBody UpdateRequestDto requestDto)
    {
        scheduleService.updateSchedule(id,requestDto);
    }

    @DeleteMapping("/schedule/{id}")
    public void deleteSchedule(@PathVariable Long id)
    {
        scheduleService.deleteSchedule(id);
    }

    @PostMapping("/schedule/{userId}/{scheduleId}/{assignUserId}")
    public void assignUser( @PathVariable Long userId,@PathVariable Long scheduleId, @PathVariable Long assignUserId)
    {
        scheduleService.assginUser(userId,scheduleId, assignUserId);
    }
}
