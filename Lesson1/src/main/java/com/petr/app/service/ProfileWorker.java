package com.petr.app.service;

import com.petr.app.dto.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProfileWorker {
    private final FileService fileService;

    public ProfileWorker(FileService fileService) {
        this.fileService = fileService;
    }
    public ArrayList<Contact> getContactsList(){
       return fileService.getFileContacts();
    }
}
