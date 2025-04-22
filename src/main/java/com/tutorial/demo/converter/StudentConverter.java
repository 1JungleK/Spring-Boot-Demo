package com.tutorial.demo.converter;

import com.tutorial.demo.dao.Student;
import com.tutorial.demo.dto.StudentDTO;

public class StudentConverter {

    public static StudentDTO converterrStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());

        return studentDTO;
    }
}
