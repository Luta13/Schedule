package com.sparta.schedule.scheduleuser.entity;

import com.sparta.schedule.schedule.entity.ScheduleEntity;
import com.sparta.schedule.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ScheduleUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private ScheduleEntity schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public ScheduleUserEntity(ScheduleEntity schedule, UserEntity user){
        this.schedule = schedule;
        this.user = user;
    }
}
