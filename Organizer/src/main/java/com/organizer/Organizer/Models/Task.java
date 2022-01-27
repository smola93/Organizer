package com.organizer.Organizer.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;
    private String task_name;
    private String task_description;
    private String task_type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date task_date;
    private boolean with_reminder = false;
    private LocalDateTime created_on = LocalDateTime.now();
    private String username;

    public Task() {
    }

    public Task(Long id, String name, String description, String type, Date date, boolean withReminder, LocalDateTime createdOn, String username) {
        this.task_id = id;
        this.task_name = name;
        this.task_description = description;
        this.task_type = type;
        this.task_date = date;
        this.with_reminder = withReminder;
        this.created_on = createdOn;
        this.username = username;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }

    public String getTask_type() {
        return task_type;
    }

    public void setTask_type(String task_type) {
        this.task_type = task_type;
    }

    public Date getTask_date() {
        return task_date;
    }

    public void setTask_date(Date task_date) {
        this.task_date = task_date;
    }

    public boolean isWith_reminder() {
        return with_reminder;
    }

    public void setWith_reminder(boolean with_reminder) {
        this.with_reminder = with_reminder;
    }

    public LocalDateTime getCreated_on() {
        return created_on;
    }

    public void setCreated_on(LocalDateTime created_on) {
        this.created_on = created_on;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }
}
