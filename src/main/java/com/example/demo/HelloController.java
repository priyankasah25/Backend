package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, backend!";
    }

    @GetMapping("/user")
    public User getUser() {
        return new User("Ravi", "ravi@example.com");
    }

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Chhavi", 20, 75.5);
    }
}