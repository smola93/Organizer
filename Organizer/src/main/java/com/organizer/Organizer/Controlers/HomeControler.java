package com.organizer.Organizer.Controlers;

import com.organizer.Organizer.Models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeControler {

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
        return ("register");
    }

    @GetMapping(value = "/about")
    String returnAbout() {
        return ("about");
    }
}
