package com.petr.app.service.impl;

import com.petr.app.dto.Contact;
import com.petr.app.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;

public class ProdFileService implements FileService {

    @Value("${app.env}")
    private String env;

    @Override
    public ArrayList<Contact> getFileContacts() {
        return new ArrayList<Contact>();
    }
}
