package com.tutorial.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tutorial.demo.dto.StudentDTO;
import com.tutorial.demo.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{id}")
    public StudentDTO getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }
    
    
}
