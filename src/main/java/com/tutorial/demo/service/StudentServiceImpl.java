package com.tutorial.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tutorial.demo.converter.StudentConverter;
import com.tutorial.demo.dao.Student;
import com.tutorial.demo.dao.StudentRepository;
import com.tutorial.demo.dto.StudentDTO;

import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudentById(long id) {
        Student student =  studentRepository.findById(id).orElseThrow(RuntimeException::new);

        return StudentConverter.converterStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        List<Student> studentList = studentRepository.findByEmail(studentDTO.getEmail());
        
        if (!studentList.isEmpty()) {
            throw new IllegalStateException("Email " + studentDTO.getEmail() + "has been taken.");
        }

        Student student = studentRepository.save(StudentConverter.converterStudentDTO(studentDTO));
        return student.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("id: " + id + "does not exist!"));
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public StudentDTO updateStudentById(long id, String name, String email) {
        Student studentInDB = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("id: " + id + "does not exist!"));

        if (!StringUtils.isEmpty(name) && !studentInDB.getName().equals(name)) {
            studentInDB.setName(name);
        }

        if (!StringUtils.isEmpty(email) && !studentInDB.getEmail().equals(email)) {
            studentInDB.setEmail(email);
        }

        Student student = studentRepository.save(studentInDB);
        
        return StudentConverter.converterStudent(student);
    }
}
