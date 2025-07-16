package com.devio.devio_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Root endpoint
    @GetMapping("/")
    public String home() {
        return "Welcome to Devio Backend API! Visit /api/hello for the API endpoint.";
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
