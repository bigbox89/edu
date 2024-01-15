package com.petr.app.service.impl;

import com.petr.app.config.AddStudentEvent;
import com.petr.app.config.DeleteStudentEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentsEventListenerImpl {

    @EventListener
    void handleAddStudentEvent(AddStudentEvent event) {
        System.out.println(event.toString());
    }

    @EventListener
    void handleDeleteStudentEvent(DeleteStudentEvent event) {
        System.out.println(event.toString());
    }
}
