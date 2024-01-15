package com.petr.app.service;

import com.petr.app.config.AddStudentEvent;
import com.petr.app.config.DeleteStudentEvent;

public interface StudentsEventListener {

    void handleAddStudentEvent(AddStudentEvent event);

    void handleDeleteStudentEvent(DeleteStudentEvent event);
}
