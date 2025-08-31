package com.example.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")      // Root URL
    public String root() {
        return "Welcome to Spring Boot CRUD App!";
    }

    @GetMapping("/home")  // /home URL
    public String home() {
        return "This is the Home page!";
    }
}
