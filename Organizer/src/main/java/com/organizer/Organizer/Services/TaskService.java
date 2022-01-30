package com.organizer.Organizer.Services;

import com.organizer.Organizer.Models.Task;
import com.organizer.Organizer.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> findAll() {
        var tasks = (List<Task>) repository.findAll();

        return tasks;
    }

    @Override
    public List<Task> findAllForUsers(String username) {
        var tasks = (List<Task>) repository.findAllForUsers(username);

        return tasks;
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Task> findByTaskDate(Date date) {
        var tasks = (List<Task>) repository.findByDate(date);

        return tasks;
    }

    @Override
    public List<Task> findByTaskDateForUsers(Date date, String username) {
        var tasks = (List<Task>) repository.findByDateForUsers(date, username);

        return tasks;
    }

    @Override
    public List<Task> findByTaskTypeForUsers(String type, String username) {
        var tasks = (List<Task>) repository.findByTypeForUsers(type, username);

        return tasks;
    }

    @Override
    public List<Task> findByTaskType(String type) {
        var tasks = (List<Task>) repository.findByType(type);

        return tasks;
    }
}
