package com.codecat.TidyUp.service;

import com.codecat.TidyUp.model.Task;
import com.codecat.TidyUp.model.User;
import com.codecat.TidyUp.repository.TaskRepository;
import com.codecat.TidyUp.repository.UserRepository;
import com.codecat.TidyUp.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final UserService userService;



    public TaskService(TaskRepository taskRepository, UserRepository userRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Task createTask(Task task, Long user_id){
        User user = userService.getUserInfo(user_id).orElseThrow(()-> new RuntimeException("User not found!"));
        task.setUser(user);
        return taskRepository.save(task);
    }

    public Task deleteTask(Long task_id){
        Task task = taskRepository.findById(task_id).orElseThrow(()-> new RuntimeException("Task not found!"));
        taskRepository.delete(task);
        return task;
    }

}
