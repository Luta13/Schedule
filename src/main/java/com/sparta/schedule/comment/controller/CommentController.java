package com.sparta.schedule.comment.controller;

import com.sparta.schedule.comment.dto.CommentRequestDto;
import com.sparta.schedule.comment.dto.CommentResponseDto;
import com.sparta.schedule.comment.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class CommentController {
    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }



    @PostMapping("/{scheduleId}/comment")
    public CommentResponseDto addComment(@RequestBody CommentRequestDto requestDto,@PathVariable Long scheduleId )
    {
        return commentService.addComment(requestDto,scheduleId);
    }

    @GetMapping("/{scheduleId}/comments")
    public List<CommentResponseDto> getComments(@PathVariable(name = "scheduleId") Long scheduleId)
    {
        return commentService.getComments(scheduleId);
    }

    @GetMapping("/comment/{id}")
    public CommentResponseDto getComment(@PathVariable(name = "scheduleId") Long scheduleId,@PathVariable Long id)
    {
        return commentService.getComment(id);
    }

    @PatchMapping("/{scheduleId}/comment/{id}") // 전체수정 put, 단건수정 patch
    public void updateComment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto)
    {
        commentService.updateComment(id,requestDto);
    }

    @DeleteMapping("/{scheduleId}/comment/{id}")
    public void deleteComment(@PathVariable(name = "scheduleId") Long scheduleId, @PathVariable(name = "id") Long id)
    {
        commentService.deleteComment(id,scheduleId);
    }

}
