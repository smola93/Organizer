package com.organizer.Organizer.Controlers;

import com.organizer.Organizer.Models.Task;
import com.organizer.Organizer.Services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TaskControler {

    @Autowired
    private ITaskService tasksService;

    @GetMapping(value = "/tasks")
    String returnTasks(Model model) {
        var tasks = (List<Task>) tasksService.findAll();
        model.addAttribute("title", "Lista zadań:");
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        return ("tasks");
    }

    @PostMapping(value = "/tasks")
    public String taskSubmit(@ModelAttribute Task task, Model model) {
        Task createdTask = tasksService.createTask(task);
        model.addAttribute("task", createdTask);
        return ("redirect:/");
    }

    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        tasksService.deleteTaskById(id);
        return ("redirect:/");
    }

    @PostMapping(value = "/by-date/")
    public String showRecordsByDate(@RequestParam("date") Date date, Model model) {
        var tasks = (List<Task>) tasksService.findByTaskDate(date);
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        return ("tasks");
    }

    @PostMapping(value = "/by-type/")
    public String showRecordsByType(@RequestParam("type") String type, Model model) {
        var tasks = (List<Task>) tasksService.findByTaskType(type);
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        return ("tasks");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }
}
