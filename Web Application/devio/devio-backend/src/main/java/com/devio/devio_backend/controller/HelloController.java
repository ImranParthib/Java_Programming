package com.devio.devio_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Root endpoint
    @GetMapping("/")
    public String home() {
        return "Welcome to Devio Company Listing API! Available endpoints: /api/hello, /api/companies";
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }
}
