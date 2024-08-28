package com.sparta.schedule.user.entity;


import com.sparta.schedule.common.utils.TimeEntity;
import com.sparta.schedule.scheduleuser.entity.ScheduleUserEntity;
import com.sparta.schedule.user.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Getter
@NoArgsConstructor
public class UserEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<ScheduleUserEntity> scheduleUser;


    public UserEntity(UserRequestDto requestDto)
    {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
    }

    public void update(UserEntity userEntity)
    {
        this.username = userEntity.getUsername();
        this.email = userEntity.getEmail();

    }

}
