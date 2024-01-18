package com.petr.app.service.impl;

import com.petr.app.dto.Student;
import com.petr.app.service.StudentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {
    @Value("${app.createStudentsOnStartup}")
    private boolean createStudentsOnStartup;

    @Value("${app.numberOfStudents}")
    private int numberOfStudents;

    private Map<String, Student> students = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void createStudentsOnStartup() {
        if (createStudentsOnStartup) {
            for (int i = 0; i < numberOfStudents; i++) {
                Student student = new Student();
                student.setId(UUID.randomUUID().toString());
                student.setFirstName("FirstName" + i);
                student.setLastName("LastName" + i);
                student.setAge(20 + i);
                addStudent(student);
            }
        }
    }
    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public void removeStudent(String id) {
        students.remove(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
}