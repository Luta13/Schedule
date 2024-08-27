package com.sparta.schedule.comment.controller;

import com.sparta.schedule.comment.dto.CommentRequestDto;
import com.sparta.schedule.comment.dto.CommentResponseDto;
import com.sparta.schedule.comment.service.CommentService;
import com.sparta.schedule.schedule.dto.UpdateRequestDto;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api/schedules/{scheduleId}")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping("/comments")
    public CommentResponseDto addComment(@RequestBody CommentRequestDto requestDto,@PathVariable Long scheduleId )
    {
        return commentService.addComment(requestDto,scheduleId);
    }

    @GetMapping("/comments")
    public List<CommentResponseDto> getComments(@PathVariable(name = "scheduleId") Long scheduleId)
    {
        return commentService.getComments(scheduleId);
    }

    @GetMapping("/comment/{id}")
    public CommentResponseDto getComment(@PathVariable(name = "scheduleId") Long scheduleId,@PathVariable Long id)
    {
        return commentService.getComment(scheduleId,id);
    }

    @PatchMapping("/comments/{id}") // 전체수정 put, 단건수정 patch
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto)
    {
        commentService.updateComment(id,requestDto);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable(name = "scheduleId") Long scheduleId, @PathVariable(name = "id") Long id)
    {
        commentService.deleteComment(id,scheduleId);
    }

}
