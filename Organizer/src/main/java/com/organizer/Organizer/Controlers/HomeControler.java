package com.organizer.Organizer.Controlers;

import com.organizer.Organizer.Models.Task;
import com.organizer.Organizer.Models.User;
import com.organizer.Organizer.Services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeControler {

    @Autowired
    private IUserService userService;

    @GetMapping
    String returnHome(Model model) {
        model.addAttribute("title", "Witaj w aplikacji Organizer 1.0 do organizowania twojego czasu!");
        return ("home");
    }

    @GetMapping(value = "/login")
    String login(Model model) {
        model.addAttribute("title", "Zaloguj się do aplikacji:");
        return ("login");
    }

    @GetMapping(value = "/register")
    String register(Model model) {
        model.addAttribute("title", "Zarejestruj nowe konto:");
        model.addAttribute("user", new User());
        return ("register");
    }

    @PostMapping(value = "/register")
    public String doRegistration(@ModelAttribute User user, Model model) {
        if (userService.isUsernameExists(user.getUsername())) {
            return ("username-exists");
        }
        else {
            User createdUser = userService.createUser(user);
            model.addAttribute("user", createdUser);
            model.addAttribute("title", "Z powodzeniem udało ci się zarejestrować użytkownika: " + user.getUsername());
            return ("register-done");
        }
    }

    @GetMapping(value = "/about")
    String returnAbout() {
        return ("about");
    }

//    @GetMapping(value = "/register-done")
//    String returnRegisterDone() {
//        return ("register-done");
//    }
}
