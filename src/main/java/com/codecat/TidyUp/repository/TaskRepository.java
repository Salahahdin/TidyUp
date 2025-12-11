package com.codecat.TidyUp.repository;

import com.codecat.TidyUp.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public class TaskRepository {
    public interface TaskRepo extends JpaRepository<Task, Long> {
    }
}
