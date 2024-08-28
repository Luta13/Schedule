package com.sparta.schedule.schedule.entity;


import com.sparta.schedule.comment.entity.CommentEntity;
import com.sparta.schedule.common.utils.TimeEntity;
import com.sparta.schedule.schedule.dto.UpdateRequestDto;
import com.sparta.schedule.scheduleuser.entity.ScheduleUserEntity;
import com.sparta.schedule.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "schedule")
@NoArgsConstructor
public class ScheduleEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;




    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "schedule",cascade = CascadeType.REMOVE)
    private List<CommentEntity> comments;

    @OneToMany(mappedBy ="schedule")
    private List<ScheduleUserEntity> scheduleUser;


    public void update(UpdateRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();

    }
    public ScheduleEntity(UserEntity user, String title, String content) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.scheduleUser = user.getScheduleUser();

    }
    public List<UserEntity> getAssignedUsers()
    {
       return scheduleUser.stream().map(ScheduleUserEntity::getUser).toList();
    }


}
