package com.weekendJava.taskManager.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class TaskEntity {

    @Id
    private Long id;
    private String title;
    private String description;
    private String TaskStatus;
    private String userName;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;

}