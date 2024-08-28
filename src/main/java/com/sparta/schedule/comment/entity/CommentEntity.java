package com.sparta.schedule.comment.entity;
import com.sparta.schedule.comment.dto.CommentRequestDto;
import com.sparta.schedule.common.utils.TimeEntity;
import com.sparta.schedule.schedule.entity.ScheduleEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Table(name = "comment")
@Entity
@NoArgsConstructor
public class CommentEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name="username", nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private ScheduleEntity schedule;


    public CommentEntity(CommentRequestDto requestDto)
    {

        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
    }

    public void update(CommentRequestDto requestDto)
    {
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
    }





}
