package com.petr.app.service;

import com.petr.app.dto.Student;
import org.springframework.context.ApplicationEventPublisherAware;
import java.util.List;

public interface StudentService extends ApplicationEventPublisherAware {
     void addStudent(Student student);
     void removeStudent(String id);
     List<Student> getAllStudents();
}