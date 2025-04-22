package com.tutorial.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class TestController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello world!";
    }

    @GetMapping("/list")
    public List<String> getList() {
        return List.of("Hello", "world!");
    }
    
}
