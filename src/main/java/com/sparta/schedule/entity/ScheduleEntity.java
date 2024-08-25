package com.sparta.schedule.entity;


import com.sparta.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor
public class ScheduleEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = true)
    private String username;

    @Column(name = "title", nullable = true)
    private String title;

    @Column(name = "content", nullable = true)
    private String content;

    public ScheduleEntity(ScheduleRequestDto requestDto)
    {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
    public void update(ScheduleRequestDto requestDto)
    {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }


}
