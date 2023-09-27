package com.example.application.controllers;

import com.example.application.entities.Student;
import com.example.application.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
        studentRepository.save(student);
    }
    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
