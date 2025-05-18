package com.weekendJava.taskManager.Controller;

import com.weekendJava.taskManager.Service.TaskService;
import com.weekendJava.taskManager.model.dto.TaskDTO;
import com.weekendJava.taskManager.model.dto.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping
    public Response CreateTask(@RequestBody TaskDTO taskDTO) {
        Response response;
        response=taskService.createTask(taskDTO);
        return response;

    }
}
