package com.weekendJava.taskManager.Controller;

import com.weekendJava.taskManager.Service.TaskService;
import com.weekendJava.taskManager.model.dto.TaskDTO;
import com.weekendJava.taskManager.model.dto.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping("/CreateTask")
    public Response CreateTask(@RequestBody TaskDTO taskDTO) {
        Response response;
        response=taskService.createTask(taskDTO);
        return response;

    }
    @GetMapping("/getTaskById")
    public Response getTaskBasedOnId(@RequestBody Long id) {
        Response response;
        response=taskService.getTaskBasedOnId(id);
        return response;

    }
    @GetMapping("/tasksByUserName")
    public Response getTasksBasedOnUserName(@RequestBody String userName) {
        Response response;
        response=taskService.getTasksBasedOnUserName(userName);
        return response;

    }
    @GetMapping("/getAllTasks")
    public Response getAllTask() {
        Response response;
        response=taskService.getAllTask();
        return response;

    }
    @PostMapping("/updateTask")
    public Response UpdateTask(@RequestBody TaskDTO taskDTO) {
        Response response;
        response=taskService.UpdateTask(taskDTO);
        return response;

    }
    @GetMapping("/deleteTask")
    public Response deleteTask(@RequestBody Long id) {
        Response response;
        response=taskService.deleteTask(id);
        return response;

    }
}
