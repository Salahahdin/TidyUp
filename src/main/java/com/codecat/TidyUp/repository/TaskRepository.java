package com.codecat.TidyUp.repository;

import com.codecat.TidyUp.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TaskRepository extends JpaRepository<Task, Long> {
    }
