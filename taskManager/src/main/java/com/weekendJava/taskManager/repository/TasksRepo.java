package com.weekendJava.taskManager.repository;


import com.weekendJava.taskManager.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TasksRepo extends JpaRepository<TaskEntity,Long> {
    Optional<TaskEntity> findById(Long Id);
    Optional<TaskEntity> findByUserName(String userName);
}
