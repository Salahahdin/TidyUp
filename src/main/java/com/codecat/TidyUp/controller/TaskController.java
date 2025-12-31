package com.codecat.TidyUp.controller;

import com.codecat.TidyUp.model.Task;
import com.codecat.TidyUp.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("user/{user_id}")
    public List<Task> getTasksByUserId(@PathVariable Long user_id){
        return taskService.getTasksByUserId(user_id);
    }

    @PostMapping("/")
    public Task createTask(@RequestBody Task task, @RequestParam Long user_id){
        return taskService.createTask(task, user_id);
    }

    @DeleteMapping("/{task_id}")
    public void deleteTask (@PathVariable Long task_id){
        taskService.deleteTask(task_id);
    }
}
