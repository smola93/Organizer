package com.organizer.Organizer.Services;

import com.organizer.Organizer.Models.Task;

import java.util.List;

public interface ITaskService {
    List<Task> findAll();
    Task createTask(Task task);
}
