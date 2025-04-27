package com.tutorial.demo.converter;

import com.tutorial.demo.dao.Student;
import com.tutorial.demo.dto.StudentDTO;

public class StudentConverter {

    public static StudentDTO converterStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());

        return studentDTO;
    }

    public static Student converterStudentDTO(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        
        return student;
    }
}
