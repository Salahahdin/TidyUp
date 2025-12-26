package com.codecat.TidyUp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long task_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private Date createdAt;
    private Date closedAt;
    private boolean isDone;
    private String description;
    private Date dueDate;
    private String priority;
    private String title;
    private String tags;
    private Date updatedAt;


}
