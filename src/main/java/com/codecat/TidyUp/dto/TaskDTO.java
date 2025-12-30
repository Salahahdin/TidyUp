package com.codecat.TidyUp.dto;

import java.util.Date;

public record TaskDTO (String title, String description, Long user_id, String username, Long task_id, Boolean isDone, Date dueDate, Date createdAt){
}
