package com.tutorial.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tutorial.demo.converter.StudentConverter;
import com.tutorial.demo.dao.Student;
import com.tutorial.demo.dao.StudentRepository;
import com.tutorial.demo.dto.StudentDTO;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(long id) {
        Student student =  studentRepository.findById(id).orElseThrow(RuntimeException::new);

        return StudentConverter.converterrStudent(student);
    }
}
