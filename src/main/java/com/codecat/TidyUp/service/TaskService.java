package com.codecat.TidyUp.service;

import com.codecat.TidyUp.model.Task;
import com.codecat.TidyUp.repository.TaskRepository;
import com.codecat.TidyUp.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;



    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public Task createTask(Task task, Long user_id){
        if(userRepository.)
    }
}
