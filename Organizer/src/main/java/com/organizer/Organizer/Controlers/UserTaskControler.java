package com.organizer.Organizer.Controlers;

import com.organizer.Organizer.Models.Task;
import com.organizer.Organizer.Models.User;
import com.organizer.Organizer.Services.ITaskService;
import com.organizer.Organizer.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class UserTaskControler {
    @Autowired
    private ITaskService tasksService;

    @Autowired
    private IUserService userService;

    @GetMapping(value = "/user-tasks/{user-id}")
    String returnTasks(Model model, @PathVariable("user-id") Long userId) {
        Optional<User> user = userService.getUserById(userId);
        User currentUser = null;
        if (user.isPresent()) {
            currentUser = user.get();
        }
        var tasks = (List<Task>) tasksService.findAllForUsers(currentUser.getUsername());
        model.addAttribute("title", "Lista zadań:");
        model.addAttribute("welcomeusername", "Witaj " + currentUser.getUsername() + "!");
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        model.addAttribute("id", userId);
        model.addAttribute("username", currentUser.getUsername());
        return ("user-tasks");
    }

    @PostMapping(value = "/user-tasks/{user-id}")
    public String taskSubmit(@ModelAttribute Task task, @PathVariable("user-id") Long userId, Model model) {
        Task createdTask = tasksService.createTask(task);
        model.addAttribute("task", createdTask);
        return ("redirect:/user-tasks/" + userId);
    }

    @PostMapping(value = "/delete-user-tasks/{user-id}/{id}")
    public String delete(@PathVariable("user-id") Long userId, @PathVariable("id") Long id) {
        tasksService.deleteTaskById(id);
        return ("redirect:/user-tasks/" + userId);
    }

    @PostMapping(value = "/by-date-and-user/{user-id}")
    public String showRecordsByDate(@PathVariable("user-id") Long userId, @RequestParam("date") Date date, Model model) {
        Optional<User> user = userService.getUserById(userId);
        User currentUser = null;
        if (user.isPresent()) {
            currentUser = user.get();
        }
        var tasks = (List<Task>) tasksService.findByTaskDateForUsers(date, currentUser.getUsername());
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        model.addAttribute("id", userId);
        model.addAttribute("username", currentUser.getUsername());
        return ("user-tasks");
    }

    @PostMapping(value = "/by-type-and-user/{user-id}")
    public String showRecordsByType(@PathVariable("user-id") Long userId, @RequestParam("type") String type, Model model) {
        Optional<User> user = userService.getUserById(userId);
        User currentUser = null;
        if (user.isPresent()) {
            currentUser = user.get();
        }
        var tasks = (List<Task>) tasksService.findByTaskTypeForUsers(type, currentUser.getUsername());
        model.addAttribute("tasks", tasks);
        model.addAttribute("task", new Task());
        model.addAttribute("id", userId);
        model.addAttribute("username", currentUser.getUsername());
        return ("user-tasks");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }
}
