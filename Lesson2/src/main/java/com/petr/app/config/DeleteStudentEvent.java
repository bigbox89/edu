package com.petr.app.config;

import org.springframework.context.ApplicationEvent;

public class DeleteStudentEvent extends ApplicationEvent {
    public DeleteStudentEvent(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Student with id" + this.getSource() + " deleted :: " + this.getSource();
    }
}
