package com.organizer.Organizer.Services;

import com.organizer.Organizer.Models.Task;

import java.util.Date;
import java.util.List;

public interface ITaskService {
    List<Task> findAll();
    Task createTask(Task task);
    void deleteTaskById(Long id);
    List<Task> findByTaskDate(Date date);
    List<Task> findByTaskType(String type);
}
