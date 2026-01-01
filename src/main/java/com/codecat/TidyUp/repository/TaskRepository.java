package com.codecat.TidyUp.repository;

import com.codecat.TidyUp.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long id);
    }
