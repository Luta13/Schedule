package com.sparta.schedule.controller;


import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.repository.ScheduleRepository;
import com.sparta.schedule.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }
    @PostMapping("/schedules")
    public ScheduleResponseDto addSchedule(@RequestBody ScheduleRequestDto requestDto)
    {
        return scheduleService.addSchedule(requestDto);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules()
    {
        return scheduleService.getSchedules();
    }

    @GetMapping("/schedule/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id)
    {
        return scheduleService.getSchedule(id);
    }

    @PutMapping("/schedules/{id}")
    public void updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto requestDto)
    {
        scheduleService.updateSchedule(id,requestDto);
    }
}
