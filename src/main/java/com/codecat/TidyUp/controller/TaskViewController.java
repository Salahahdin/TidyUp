package com.codecat.TidyUp.controller;

import com.codecat.TidyUp.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskViewController {

    private final TaskService taskService;

    public TaskViewController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/user/{userId}")
    public String listUserTasks(@PathVariable Long userId, Model model) {
        model.addAttribute("tasks", taskService.getTasksByUserId(userId));
        model.addAttribute("userId", userId);
        return "tasks.html";
    }
}
