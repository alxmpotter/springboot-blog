package com.codeup.blog.controllers;

import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UsersController {
    private PasswordEncoder encoder;
    private UsersRepository repository;

    public UsersController(PasswordEncoder encoder, UsersRepository repository) {
        this.encoder = encoder;
        this.repository = repository;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
              model.addAttribute("user", new User());
                return "users/register";
            }

    @PostMapping("/register")
    public String registerUser(@Valid User user, Errors validation, Model model) {
//        User existingUser = repository.findByUsername(user.getUsername());
//        User existingEmail = repository.findByEmail(user.getEmail());
//
//        if (existingUser == null || existingEmail ==null ) {
//            return "redirect:/register";
//        }

        if (validation.hasErrors()) {
            model.addAttribute("errors", validation);
            model.addAttribute("user", user);
            return "users/register";
        }

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);
        repository.save(user);

        return "redirect:/posts";
    }
}
