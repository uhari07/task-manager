package com.weekendJava.taskManager.Service;

import com.weekendJava.taskManager.config.TaskMapper;
import com.weekendJava.taskManager.model.dto.TaskDTO;
import com.weekendJava.taskManager.model.dto.Response;
import com.weekendJava.taskManager.model.entity.TaskEntity;
import com.weekendJava.taskManager.repository.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final TasksRepo tasksRepo;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TasksRepo tasksRepo, TaskMapper taskMapper) {
        this.tasksRepo = tasksRepo;
        this.taskMapper = taskMapper;
    }


    public Response createTask(TaskDTO taskDTO){
        Response response=new Response();
        try{
            TaskEntity taskEntity = taskMapper.toEntity(taskDTO);
            TaskEntity saveTask=tasksRepo.save(taskEntity);
            response.setSuccess(true);
            response.setMessage("Successfully created task");
            response.setData(saveTask);
        }
        catch(Exception e){
            response.setSuccess(false);
            response.setMessage("Failed to create task because of "+e.getMessage());
        }
        return response;
    }

    public Response getTaskBasedOnId(Long id){
        TaskDTO taskDTO;
        Response response=new Response();
        try{
            Optional<TaskEntity> taskEntity=tasksRepo.findById(id);
            if(taskEntity.isPresent()){
                taskDTO=taskMapper.toDto(taskEntity.get());
                response.setSuccess(true);
                response.setMessage("Task Details for id"+id);
                response.setData(taskDTO);

            }
            else{
                response.setSuccess(false);
                response.setMessage("No Tasks found for id :"+id);
            }
        }
        catch(Exception e){
            response.setSuccess(false);
            response.setMessage("Failed to fetch task due to "+e.getMessage());
        }
        return response;
    }
    public Response getTasksBasedOnUserName(String userName){
        TaskDTO taskDTO;
        Response response=new Response();
        try{
            Optional<TaskEntity> taskEntity=tasksRepo.findByUserName(userName);
            if(taskEntity.isPresent()){
                taskDTO=taskMapper.toDto(taskEntity.get());
                response.setSuccess(true);
                response.setMessage("Task Details for userName"+userName);
                response.setData(taskDTO);

            }
            else{
                response.setSuccess(false);
                response.setMessage("No Tasks found for userName :"+userName);
            }
        }
        catch(Exception e){
            response.setSuccess(false);
            response.setMessage("Failed to fetch task due to "+e.getMessage());
        }
        return response;
    }
    public Response getAllTask(){
        Response response=new Response();
        try{
            List<TaskEntity> taskEntity=tasksRepo.findAll();
            if(taskEntity.isEmpty()){
                response.setSuccess(false);
                response.setMessage("No Tasks found");

            }
            List<TaskDTO> taskDTOs = taskEntity.stream().map(taskMapper::toDto).collect(Collectors.toList());
            response.setSuccess(true);
            response.setMessage("Task Details:");
            response.setData(taskDTOs);

        }
        catch(Exception e){
            response.setSuccess(false);
            response.setMessage("Failed to fetch task due to "+e.getMessage());
        }
        return response;
    }

    public Response UpdateTask(TaskDTO taskDTO){
        Response response=new Response();
        try{
            Optional<TaskEntity> taskEntity=tasksRepo.findById(taskDTO.getId());
            if(taskEntity.isPresent()){
                taskEntity.get().setTitle(taskDTO.getTitle());
                taskEntity.get().setDescription(taskDTO.getDescription());
                taskEntity.get().setDueDate(taskDTO.getDueDate());
                taskEntity.get().setUserName(taskDTO.getUserName());
                taskDTO=taskMapper.toDto(taskEntity.get());
                response.setSuccess(true);
                response.setMessage("Task Details Updated");
                response.setData(taskDTO);

            }
            else{
                response.setSuccess(false);
                response.setMessage("No Tasks found to update");
            }
        }
        catch(Exception e){
            response.setSuccess(false);
            response.setMessage("Failed to fetch task due to "+e.getMessage());
        }
        return response;
    }

    public Response deleteTask(Long id){
        Response response=new Response();
        try{
            if(tasksRepo.existsById(id)){
                tasksRepo.deleteById(id);
                response.setSuccess(true);
                response.setMessage("Task Deleted for id"+id);

            }
            else{
                response.setSuccess(false);
                response.setMessage("No Tasks found for id :"+id);
            }
        }
        catch(Exception e){
            response.setSuccess(false);
            response.setMessage("Failed to fetch task due to "+e.getMessage());
        }
        return response;
    }

}
