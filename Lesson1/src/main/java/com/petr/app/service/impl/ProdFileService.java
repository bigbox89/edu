package com.petr.app.service.impl;

import com.petr.app.dto.Contact;
import com.petr.app.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ProdFileService implements FileService {

    @Value("${app.env}")
    private String env;

    @Value("${save.path}")
    private String savePath;
    @Override
    public ArrayList<Contact> getFileContacts() {
        return new ArrayList<Contact>();
    }

    @Override
    public String getSavePath() {
        return savePath;
    }
}
