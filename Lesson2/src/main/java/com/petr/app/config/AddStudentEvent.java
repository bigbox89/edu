package com.petr.app.config;

import com.petr.app.dto.Student;
import org.springframework.context.ApplicationEvent;

public class AddStudentEvent extends ApplicationEvent {
    public AddStudentEvent(Student student) {
        super(student);
    }

    @Override
    public String toString() {
        return "New Student saved :: " + this.getSource();
    }
}
