package com.sparta.schedule.schedule.service;


import com.sparta.schedule.comment.dto.CommentResponseDto;
import com.sparta.schedule.schedule.dto.SchedulePageResponseDto;
import com.sparta.schedule.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.schedule.dto.UpdateRequestDto;
import com.sparta.schedule.schedule.entity.ScheduleEntity;
import com.sparta.schedule.schedule.repository.ScheduleRepository;
import com.sparta.schedule.scheduleuser.dto.ScheduleUserRequestDto;
import com.sparta.schedule.scheduleuser.dto.ScheduleUserResponseDto;
import com.sparta.schedule.scheduleuser.entity.ScheduleUserEntity;
import com.sparta.schedule.scheduleuser.repository.ScheduleUserRepository;
import com.sparta.schedule.user.entity.UserEntity;
import com.sparta.schedule.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.Builder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {


    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final ScheduleUserRepository scheduleUserRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository, ScheduleUserRepository scheduleUserRepository){
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
        this.scheduleUserRepository = scheduleUserRepository;
    }

    public void addSchedule(ScheduleRequestDto requestDto) {
        UserEntity userEntity = userRepository.findById(requestDto.getUserId()).orElse(null);
        ScheduleEntity scheduleEntity = new ScheduleEntity(userEntity,requestDto.getTitle(),requestDto.getContent());
        ScheduleEntity saveEntity = scheduleRepository.save(scheduleEntity);
    }

    public List<SchedulePageResponseDto> getSchedules(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC,"updatedAt"));

        Page<ScheduleEntity> schedulePage = scheduleRepository.findAll(pageable);

        return schedulePage.stream().map(SchedulePageResponseDto::new).toList(  );
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
        ScheduleResponseDto responseDto = new ScheduleResponseDto(scheduleEntity);
        responseDto.setScheduleUsers(scheduleEntity.getAssignedUsers().stream().map(ScheduleUserResponseDto::new).toList());


        return responseDto;
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    public void assginUser(Long userId,Long scheduleId, Long assignUserId) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(scheduleId).orElse(null);
        if(scheduleEntity.getUser().getId().equals(userId))
        {
            UserEntity assignUserEntity = userRepository.findById(assignUserId).orElse(null);
            ScheduleUserEntity batchEntity = new ScheduleUserEntity(scheduleEntity,assignUserEntity);
            scheduleUserRepository.save(batchEntity);

        }

    }



}
