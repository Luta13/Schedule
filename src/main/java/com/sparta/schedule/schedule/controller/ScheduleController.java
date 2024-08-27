package com.sparta.schedule.schedule.controller;


import com.sparta.schedule.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.schedule.dto.UpdateRequestDto;
import com.sparta.schedule.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ScheduleResponseDto addSchedule(@RequestBody ScheduleRequestDto requestDto)
    {
        return scheduleService.addSchedule(requestDto);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> getSchedules(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize)

    {
        return scheduleService.getSchedules(pageNo, pageSize);
    }

    @GetMapping("/schedule/{id}")
    public ScheduleResponseDto getSchedule(@PathVariable Long id)
    {
        return scheduleService.getSchedule(id);
    }

    @PatchMapping("/schedules/{id}") // 전체수정 put, 단건수정 patch
    public void updateSchedule(@PathVariable Long id, @RequestBody UpdateRequestDto requestDto)
    {
        scheduleService.updateSchedule(id,requestDto);
    }
}
