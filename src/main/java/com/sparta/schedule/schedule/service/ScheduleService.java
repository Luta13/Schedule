package com.sparta.schedule.schedule.service;


import com.sparta.schedule.schedule.dto.SchedulePageResponseDto;
import com.sparta.schedule.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.schedule.dto.UpdateRequestDto;
import com.sparta.schedule.schedule.entity.ScheduleEntity;
import com.sparta.schedule.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<SchedulePageResponseDto> getSchedules(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC,"updatedAt"));

        Page<ScheduleEntity> schedulePage = scheduleRepository.findAll(pageable);

        return schedulePage.stream().map(SchedulePageResponseDto::new).toList();
    }

    @Transactional
    public void updateSchedule(Long id, UpdateRequestDto requestDto) {

         ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElse(null);
         scheduleEntity.update(requestDto);
         // scheduleRepository.save(scheduleEntity); /// Transcactional 하면 save 없어도 커밋(변경 감지)
         // 2-6 ~ 2~13
    }

        public ScheduleResponseDto getSchedule(Long id) {
            ScheduleEntity scheduleEntity = scheduleRepository.findById(id).orElse(null);

            ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(scheduleEntity);
            return scheduleResponseDto;

        }
}
