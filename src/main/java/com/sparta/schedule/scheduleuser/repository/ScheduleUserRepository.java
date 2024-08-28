package com.sparta.schedule.scheduleuser.repository;

import com.sparta.schedule.scheduleuser.entity.ScheduleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleUserRepository extends JpaRepository<ScheduleUserEntity,Long> {

}
