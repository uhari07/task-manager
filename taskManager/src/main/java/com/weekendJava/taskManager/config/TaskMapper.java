package com.weekendJava.taskManager.config;

import com.weekendJava.taskManager.model.dto.TaskDTO;
import com.weekendJava.taskManager.model.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper  {

    public TaskEntity toEntity(TaskDTO taskDTO){
        TaskEntity taskEntity=new TaskEntity();
        taskEntity.setTaskStatus(taskDTO.getTaskStatus());
        taskEntity.setTitle(taskDTO.getTitle());
        taskEntity.setTaskStatus(taskDTO.getTaskStatus());
        taskEntity.setCreatedAt(taskDTO.getCreatedAt());
        taskEntity.setUpdatedAt(taskDTO.getUpdatedAt());
        taskEntity.setDueDate(taskDTO.getDueDate());
        taskEntity.setUserId(taskDTO.getUserId());
        taskEntity.setUserName(taskDTO.getUserName());
        return taskEntity;

    }

    public TaskDTO toDto(TaskEntity taskEntity){
        TaskDTO taskDTO=new TaskDTO();
        taskDTO.setTaskStatus(taskEntity.getTaskStatus());
        taskDTO.setTitle(taskEntity.getTitle());
        taskDTO.setTaskStatus(taskEntity.getTaskStatus());
        taskDTO.setCreatedAt(taskEntity.getCreatedAt());
        taskDTO.setUpdatedAt(taskEntity.getUpdatedAt());
        taskDTO.setDueDate(taskEntity.getDueDate());
        taskDTO.setUserId(taskEntity.getUserId());
        return taskDTO;
    }

}
