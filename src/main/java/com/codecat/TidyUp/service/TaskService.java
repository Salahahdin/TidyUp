package com.codecat.TidyUp.service;

import com.codecat.TidyUp.dto.TaskDTO;
import com.codecat.TidyUp.model.Task;
import com.codecat.TidyUp.model.User;
import com.codecat.TidyUp.repository.TaskRepository;
import com.codecat.TidyUp.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    public TaskDTO createTask(TaskDTO taskDTO, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setTitle(taskDTO.title());
        task.setDescription(taskDTO.description());
        task.setUser(user);
        task.setCreatedAt(new Date());
        task.setDone(false);

        Task savedTask = taskRepository.save(task);

        return new TaskDTO(
                savedTask.getTitle(),
                savedTask.getDescription(),
                user.getId(),
                user.getUsername(),
                savedTask.getTask_id(),
                savedTask.isDone(),
                savedTask.getDueDate(),
                savedTask.getCreatedAt()
        );
    }


    public Task deleteTask(Long task_id){
        Task task = taskRepository.findById(task_id).orElseThrow(()-> new RuntimeException("Task not found!"));
        taskRepository.delete(task);
        return task;
    }
    public List<Task> getTasksByUserId(Long user_id) {
        return taskRepository.findByUserId(user_id);
    }

}
