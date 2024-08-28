package com.sparta.schedule.comment.repository;
import com.sparta.schedule.comment.entity.CommentEntity;
import com.sparta.schedule.schedule.entity.ScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    List<CommentEntity> findBySchedule(ScheduleEntity scheduleEntity);

}
