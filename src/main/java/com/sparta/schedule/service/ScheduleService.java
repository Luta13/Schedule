package com.sparta.schedule.service;


import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.ScheduleEntity;
import com.sparta.schedule.repository.ScheduleRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleService {


    private final ScheduleRepository scheduleRepository;
    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto addSchedule(ScheduleRequestDto requestDto) {
        ScheduleEntity scheduleEntity = new ScheduleEntity(requestDto);

        ScheduleEntity saveEntity = scheduleRepository.save(scheduleEntity);

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(saveEntity);
        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getSchedules() {
       return scheduleRepository.findAll().stream().map(ScheduleResponseDto::new).toList();
    }

    @Transactional
    public void updateSchedule(Long id, ScheduleRequestDto requestDto) {
         ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElse(null);
         scheduleEntity.update(requestDto);
         scheduleRepository.save(scheduleEntity);

    }

        public ScheduleResponseDto getSchedule(Long id) {
            ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElse(null);

            ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(scheduleEntity);
            return scheduleResponseDto;

        }
}
