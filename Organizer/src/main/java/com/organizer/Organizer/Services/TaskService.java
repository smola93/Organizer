package com.organizer.Organizer.Services;

import com.organizer.Organizer.Models.Task;
import com.organizer.Organizer.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }
}
