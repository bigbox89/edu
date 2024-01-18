package com.petr.app.service;

import com.petr.app.dto.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {
     void addStudent(Student student);
     void removeStudent(String id);
     List<Student> getAllStudents();
}