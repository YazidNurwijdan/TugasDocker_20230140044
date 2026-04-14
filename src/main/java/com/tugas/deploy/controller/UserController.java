package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private List<User> listUser = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        if ("admin".equals(username) && "20230140044".equals(password)) {
            return "redirect:/home";
        }
        return "redirect:/?error";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("users", listUser);
        return "home";
    }

    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        listUser.add(user);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        listUser.clear();
        return "redirect:/";
    }
}