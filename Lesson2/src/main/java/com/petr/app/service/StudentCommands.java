package com.petr.app.service;

import org.springframework.shell.standard.ShellComponent;
@ShellComponent
public interface StudentCommands {
     void addStudent(String firstName, String lastName, int age) ;
     void removeStudent(String id);
     void showAllStudents();
}