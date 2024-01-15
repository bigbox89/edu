package com.petr.app.service;

import com.petr.app.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class StudentCommands {
    @Autowired
    private StudentService studentService;

    @ShellMethod("Add a new student")
    public void addStudent(String firstName, String lastName, int age) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        studentService.addStudent(student);
    }

    @ShellMethod("Remove a student by id")
    public void removeStudent(String id) {
        studentService.removeStudent(id);
    }

    @ShellMethod("Show all students")
    public void showAllStudents() {
        studentService.getAllStudents().forEach(System.out::println);
    }
}