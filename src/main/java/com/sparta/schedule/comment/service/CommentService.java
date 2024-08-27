package com.sparta.schedule.comment.service;


import com.sparta.schedule.comment.dto.CommentRequestDto;
import com.sparta.schedule.comment.dto.CommentResponseDto;
import com.sparta.schedule.comment.entity.CommentEntity;
import com.sparta.schedule.comment.repository.CommentRepository;
import com.sparta.schedule.schedule.dto.SchedulePageResponseDto;
import com.sparta.schedule.schedule.entity.ScheduleEntity;
import com.sparta.schedule.schedule.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import javax.xml.stream.events.Comment;
import java.util.List;

@Service
public class CommentService {
    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository){
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }
    public CommentResponseDto addComment(CommentRequestDto requestDto,Long scheduleId) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(scheduleId).orElse(null);
        CommentEntity commentEntity = new CommentEntity(requestDto);
        commentEntity.setSchedule(scheduleEntity);

        CommentEntity saveComment = commentRepository.save(commentEntity);
        return new CommentResponseDto(saveComment);
    }

    public CommentResponseDto getComment(Long scheduleId, Long commentId) {
        ScheduleEntity scheduleEntity = scheduleRepository.findById(scheduleId).orElse(null);
        CommentEntity commentEntity = commentRepository.findById(commentId).orElse(null);
        return new CommentResponseDto(commentEntity);
    }

    public List<CommentResponseDto> getComments(Long scheduleId) {
        return commentRepository.findByScheduleId(scheduleId).stream().map(CommentResponseDto::new).toList();
        // ScheduleEntity scheduleEntity = scheduleRepository.findById(scheduleId).orElse(null);
        //  return commentRepository.findBySchedule(scheduleEntity/*아이디로변환*/).stream().map(CommentResponseDto::new).toList();
    }

    @Transactional
    public void updateComment(Long id, CommentRequestDto requestDto) {
        CommentEntity commentEntity = commentRepository.findById(id).orElse(null);
        commentEntity.update(requestDto);
    }


    public void deleteComment(Long scheduleId, Long id) {
        CommentEntity commentEntity = commentRepository.findById(id).orElse(null);
        commentRepository.delete(commentEntity);
    }
}
